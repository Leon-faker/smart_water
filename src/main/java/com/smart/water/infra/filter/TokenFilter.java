package com.smart.water.infra.filter;


import com.alibaba.fastjson.JSONObject;
import com.smart.water.conifg.SecurityUser;
import com.smart.water.conifg.UserContext;
import com.smart.water.enums.ResultCodeEnum;
import com.smart.water.exception.BusinessException;
import com.smart.water.exception.TokenException;
import com.smart.water.infra.utils.Jwt;
import com.smart.water.infra.utils.ResultUtil;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import sun.misc.Unsafe;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.验证token
 * 2.封装用户上下文
 */
@Component
@WebFilter(urlPatterns = "/")
@Slf4j
public class TokenFilter implements Filter {
    private static final String LOGIN_PATH = "/employe/login";
    public static final String AUTHORIZATION = "authorization";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            log.info(request.getRequestURI());
            //放行 options 请求
            if(request.getMethod().equals(HttpMethod.OPTIONS.name())){
                filterChain.doFilter(request,response);
            }else if(request.getRequestURI().equals(LOGIN_PATH)){
                filterChain.doFilter(request,servletResponse);
            }else {
                //验证 token
                String token = request.getHeader(AUTHORIZATION);
                if(StringUtils.isEmpty(token)){
                    throw new TokenException(ResultCodeEnum.TOKEN_EEOR);
                }
                SecurityUser securityUser = Jwt.getTokenSecurityUser(token);
                UserContext.setCurrentUser(securityUser);
                filterChain.doFilter(servletRequest,servletResponse);
            }

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
        }catch (TokenException e){
            log.info("Token Exception:{}",e);
            response.getWriter().print(JSONObject.toJSONString(ResultUtil.fail(e.getCode(),e.getMsg(),null)));
        }finally {
            UserContext.clear();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();

    }
}

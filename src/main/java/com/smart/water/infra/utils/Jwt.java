package com.smart.water.infra.utils;

import com.smart.water.conifg.SecurityUser;
import com.smart.water.enums.ResultCodeEnum;
import com.smart.water.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@Slf4j
public class Jwt {
    private static final String secret = "smart_water";
    private static final int expire = 3600;
    private static final String header = "token";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String createToken (SecurityUser user){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);//过期时间

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject("login")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .compact();
    }

    /**
     * 生成token
     * @param subject
     * @return
     */
    public static String createToken (String subject){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);//过期时间

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    /**
     * 获取token中注册信息
     * @param token
     * @return
     */
    public static SecurityUser getTokenSecurityUser (String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            SecurityUser securityUser = SecurityUser.getInstance();
            securityUser.setId((Integer) claims.get("id"));
            securityUser.setName((String) claims.get("name"));
            return securityUser;
        }catch (Exception e){
            log.info("解析token异常:{}",e);
            throw new BusinessException(ResultCodeEnum.TOKEN_EEOR);
        }
    }

    public static Claims getTokenClaim (String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e){
            log.info("解析token异常:{}",e);
        }
        return null;
    }
    /**
     * 验证token是否过期失效
     * @param expirationTime
     * @return
     */
    public static boolean isTokenExpired (Date expirationTime) {
        return expirationTime.before(new Date());
    }

    /**
     * 获取token失效时间
     * @param token
     * @return
     */
    public static Date getExpirationDateFromToken(String token) {
        return getTokenClaim(token).getExpiration();
    }
    /**
     * 获取用户名从token中
     */
    public static String getUsernameFromToken(String token) {
        return getTokenClaim(token).getSubject();
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAtDateFromToken(String token) {
        return getTokenClaim(token).getIssuedAt();
    }
}

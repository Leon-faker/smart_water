package com.smart.water.infra.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5加密
 */
@Component
public class MD5Util {

    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    /**
     * 1次加密: 明文+随机Salt
     * @param inputPass
     * @return
     */
    public static String inputPasToFromPass(String inputPass){
        String str = "" +salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    /**
     * 2次加密: 用户输入+随机Salt
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass,String salt){
        String str = "" +salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    /**
     *
     * @param inputPass
     * @param salt
     * @return
     */
    public static String inputPassTODBPass(String inputPass,String salt){
        String fromPass = inputPasToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }
}
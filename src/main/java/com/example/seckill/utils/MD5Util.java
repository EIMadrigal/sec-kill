package com.example.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToDeliver(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String deliverPassToDBPass(String deliverPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + deliverPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String deliverPass = inputPassToDeliver(inputPass);
        return deliverPassToDBPass(deliverPass, salt);
    }

    public static void main(String[] args) {
        // d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(inputPassToDeliver("123456"));
        // b7797cce01b4b131b433b6acf4add449
        System.out.println(deliverPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456", "1a2b3c4d"));
    }

}

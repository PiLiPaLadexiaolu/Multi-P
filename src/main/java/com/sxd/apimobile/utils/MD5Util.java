package com.sxd.apimobile.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
     public static String generate(String input) {
          return DigestUtils.md5DigestAsHex(input.getBytes());
     }
}

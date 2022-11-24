package com.sxd.apimobile.auth.utils;

public class TokenParams {
    /**
     * TOKEN-KEY
     */
    public final static String TOKEN_KEY = "xxxxx";
    /**
     * TOKEN过期时间
     */
    public final static long TOKEN_TIME = 24*60*60*1000L;
    /**
     * Redis-Token过期时间
     */
    public final static long REDIS_TOKEN_TIMEOUT = 24*60*60*1000L;

    /**
     *
     */
    public final static String REDIS_TOKEN_KEY_SPLICING = "_XXXXX_TOKEN";
}

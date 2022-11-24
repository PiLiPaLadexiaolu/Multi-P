package com.sxd.apimobile.utils;
public class ResultUtil<T> {

    private String code;
    private String msg;
    private T data;

    public static ResultUtil<String> SUCCESS() {
        return new ResultUtil<String>("0", "ok", null);
    }

    public static ResultUtil<String> FAILURE() {
        return new ResultUtil<String>("-1", "error", null);
    }

    public static <D> ResultUtil<D> SUCCESS(D data) {
        return new ResultUtil<D>("0", "ok", data);
    }

    public static <D> ResultUtil<D> FAILURE(D data) {
        return new ResultUtil<D>("-1", "error", data);
    }

    public static <D> ResultUtil<D> CUSTOM(String code,String msg, D data) {
        return new ResultUtil<D>(code, msg, data);
    }

    public ResultUtil() {

    }

    public ResultUtil(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtil(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}

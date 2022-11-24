package com.sxd.apimobile.exception;

public enum ExceptionEnum {
    SUCCESS("200","成功"),
    ERROR("500","服务器异常"),
    UNAUTHORIZED("401","用户未授权");
    private String code;
    private String msg;

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

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

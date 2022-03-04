package com.xttc.demo.common;



public enum ResponCode {
    USERNAME_NOT_EMPTY(1,"用户名不为空"),
    PASSWORD_NOT_EMPTY(2,"密码不为空"),
    USERNAME_NOT_EXISTS(3,"用户名不存在"),
    PASSWORD_ERROR(4,"密码错误"),
    PARAM_NOT_EMPTY(5,"参数不为空"),
    EMAIL_NOT_EMPTY(6,"邮箱不为空"),
    USERNAME_IS_EXISTS(7,"用户名已存在"),
    EMAIL_IS_EXISTS(8,"邮箱已存在"),
    REGISTER_FAIL(9,"注册失败"),
    ;

    private int code;
    private String msg;

    ResponCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

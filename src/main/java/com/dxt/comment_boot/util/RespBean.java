package com.dxt.comment_boot.util;

public class RespBean {
    private Integer errno;
    private String msg;
    private String token;

    public static RespBean ok(String msg){
        return new RespBean(0,msg,null);
    }
    public static RespBean ok(String msg,String token){
        return new RespBean(0,msg,token);
    }
    public static RespBean error(String msg){
        return new RespBean(1,msg,null);
    }
    public static RespBean error(String msg,String token){
        return new RespBean(1,msg,token);
    }
    private RespBean() {
    }

    private RespBean(Integer errno, String msg, String token) {
        this.errno = errno;
        this.msg = msg;
        this.token = token;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

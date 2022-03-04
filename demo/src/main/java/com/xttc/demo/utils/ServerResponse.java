package com.xttc.demo.utils;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {
    private int status;
    private T data;
    private String msg;

    public ServerResponse() {
    }

    public ServerResponse(int status) {
        this.status = status;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess(){
        return this.status==0;
    }


  public static ServerResponse createServerResponseBySuccess(){
        return new ServerResponse(0);
  }
  public static <T> ServerResponse createServerResponseBySuccess(T data){
        return new ServerResponse(0,data);
  }
    public static <T> ServerResponse createServerResponseBySuccess(T data,String msg){
        return new ServerResponse(0,data,msg);
    }



    public static <T> ServerResponse createServerResponseByFail(int status){
        return new ServerResponse(status);
    }

    public static <T> ServerResponse createServerResponseByFail(int status,String msg){
        return new ServerResponse(status,null,msg);
    }
}

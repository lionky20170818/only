package com.example.only.dto;

/**
 * Created by fanguozhu on 2017/10/8.
 */
public class CommonResponse {

    private int status;

    private String code;

    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public static CommonResponse fail(String msg) {
        CommonResponse response = new CommonResponse();
        response.setStatus(-1);
        response.setCode("-1");
        response.setMsg(msg);
        return response;
    }

    public static CommonResponse ok(String msg) {
        CommonResponse response = new CommonResponse();
        response.setStatus(1);
        response.setMsg(msg);
        response.setCode("1");
        return response;
    }

    public CommonResponse(){}

    public CommonResponse(int status, String code, String msg){
        this.setStatus(status);
        this.setCode(code);
        this.setMsg(msg);
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

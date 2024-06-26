package com.veliona.elemebackend.utils;
import com.alibaba.fastjson2.JSON;

public class JsonResponse {
    private Boolean result;
    private String errCode;
    private String msg;
    private Object data;

    public JsonResponse(){
        
    }
    public JsonResponse(Object data) {
        this.result = true;
        this.data = data;
    }

    public JsonResponse(boolean rs, String msg) {
        this.result = rs;
        this.msg = msg;
    }

    public JsonResponse(boolean rs, Object data, String msg) {
        this.result = rs;
        this.data = data;
        this.msg = msg;
    }

    public JsonResponse(boolean rs, String errCode, String msg) {
        this.result = rs;
        this.errCode = errCode;
        this.msg = msg;
    }
    
    public String toString() {
        return JSON.toJSONString(this);
    }

}

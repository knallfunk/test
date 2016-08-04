package com.wisedu.cloud.smp.web.params.base;

/**
 * Created by luqiang on 8/4/16.
 */
public class BaseResponse {
    private String        msg;
    private Integer       status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

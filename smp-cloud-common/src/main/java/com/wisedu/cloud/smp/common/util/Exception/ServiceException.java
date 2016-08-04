package com.wisedu.cloud.smp.common.util.Exception;

/**
 * Created by luqiang on 8/4/16.
 */
public class ServiceException extends Exception {

    ServiceException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}

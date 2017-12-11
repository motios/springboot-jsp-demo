package com.momah.springbootjsp.service;

import com.momah.springbootjsp.Utils.ResponseResolve;
import org.springframework.http.HttpStatus;

public abstract class AbstractService {

    //return default success Response resolve: http status code=200(OK)
    public ResponseResolve OKResponseResolve(){
        ResponseResolve responseResolve = new ResponseResolve();
        responseResolve.setCode(HttpStatus.OK.value());
        responseResolve.setDescroption("");
        return responseResolve;
    }
}

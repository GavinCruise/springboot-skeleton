package com.dai7.interceptor;

import com.dai7.controller.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(req.getParameterMap() + "..."+e.getMessage());
        e.printStackTrace();
        Result<String> r = new Result<>();
        r.setMessage("服务器暂时无法处理您的请求:(");
        r.setCode(Result.ERRCODE_FAIL);
        r.setData(req.getRequestURL().toString());
        return r;
    }

}
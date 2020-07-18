package com.seata.sys.common.execption;


import com.seata.sys.common.dto.ServiceResponse;
import com.seata.sys.common.dto.enums.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述: 统一异常处理
 *
 * @author liqiao
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHanldeAdvice {

    @ExceptionHandler(Exception.class)
    public ServiceResponse handleServiceException(Exception ex){


        return ServiceResponse.createByCodeMsg(ResponseCode.ERROR.getCode(),ex.getMessage());
    }
}

package com.seata.sys.common.execption;

import com.seata.sys.common.dto.enums.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:
 *
 * @create 2018-04-18 上午9:51
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(ServiceException.class);
    private int code;
    private String desc;

    public ServiceException(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public ServiceException(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.desc = responseCode.getMsg();
    }
    public ServiceException(String msg, Throwable exception) {
        super(msg, exception);
        logger.error(msg, exception);
    }

    public ServiceException(Throwable exception) {
        super(exception);
        this.code = ResponseCode.ERROR.getCode();
        this.desc= ResponseCode.ERROR.getMsg();
        logger.error("", exception);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

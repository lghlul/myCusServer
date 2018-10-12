package com.lu.controller;

import com.lu.enums.CodeConstant;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.sql.SQLException;

/**
 * @CLassName ExceptionHandler
 * @Description 异常处理
 * @Author ll
 * @Date 2018/10/11 10:06
 **/
@ControllerAdvice
public class MyExceptionHandler {

    private static Logger logger = LogManager.getLogger(MyExceptionHandler.class);

    @ExceptionHandler()
    @ResponseBody
    public Object handleException(Exception e){
        logger.info("handleException start...e=" + e);
        if(e instanceof SQLException){
            return CodeConstant.SQL_EXCEPTION.getResultBean();
        }else if(e instanceof UnknownHostException){
            return CodeConstant.UNKNOWNHOST_EXCEPTION.getResultBean();
        }else if(e instanceof MySQLSyntaxErrorException){
            return CodeConstant.MYSQLSYNTAXERROR_EXCEPTION.getResultBean();
        }else if(e instanceof ConnectException){
            return CodeConstant.CONNECT_EXCEPTION.getResultBean();
        }else if(e instanceof CommunicationsException){
            return CodeConstant.COMMUNICATIONS_EXCEPTION.getResultBean();
        }else if(e instanceof PersistenceException){
            return CodeConstant.COMMUNICATIONS_EXCEPTION.getResultBean();
        }else{
            return CodeConstant.EXCEPTION.getResultBean();
        }
    }
}

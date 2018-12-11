package com.answer.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 日志管理
 *
 * @author clq
 *
 */
@Controller
@RequestMapping(value = "/log")
public class LogController   {
    private static Logger logger = Logger.getLogger(LogController.class);

}

package com.stone;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;


public class Log4jTest {

    @Test
    public void testQuick(){

        //开启 log4j 内置日志记录
        LogLog.setInternalDebugging(true);

        //①初始化配置信息，暂不使用配置文件
        //BasicConfigurator.configure();

        //②获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);

        //③日志记录输出
        //日志级别
        logger.fatal("fatal");// 严重错误，一般会造成系统错误并终止运行

        logger.error("error");// 错误信息，不会影响系统运行
        logger.warn("warn");// 警告信息，可能会发生问题
        logger.info("info");// 运行信息，数据连接、网络连接、IO 操作等
        logger.debug("debug");// 调试信息，一般在开发中使用，记录程序变量参数传递信息等

        logger.trace("trace");// 追踪信息，记录程序所有的流程信息
/*        for (int i = 0; i < 10000; i++) {
            logger.fatal("fatal");// 严重错误，一般会造成系统错误并终止运行

            logger.error("error");// 错误信息，不会影响系统运行
            logger.warn("warn");// 警告信息，可能会发生问题
            logger.info("info");// 运行信息，数据连接、网络连接、IO 操作等
            logger.debug("debug");// 调试信息，一般在开发中使用，记录程序变量参数传递信息等

            logger.trace("trace");// 追踪信息，记录程序所有的流程信息
        }*/
        //②获取日志记录器对象
        Logger logger1 = Logger.getLogger(Logger.class);

        //③日志记录输出
        //日志级别
        logger1.fatal("fatal apache");// 严重错误，一般会造成系统错误并终止运行

        logger1.error("error apache");// 错误信息，不会影响系统运行
        logger1.warn("warn apache");// 警告信息，可能会发生问题
        logger1.info("info apache");// 运行信息，数据连接、网络连接、IO 操作等
        logger1.debug("debug apache");// 调试信息，一般在开发中使用，记录程序变量参数传递信息等

        logger1.trace("trace apache");// 追踪信息，记录程序所有的流程信息

    }
}

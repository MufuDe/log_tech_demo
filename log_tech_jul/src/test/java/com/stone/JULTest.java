package com.stone;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JULTest {

    @Test
    public void testJUL(){
        //1.获取日志记录器对象
        //命名：通常使用当前类的全限定类名(包名+类名)
        Logger logger = Logger.getLogger("com.stone.JULTest");
        //2.日志记录输出
        //2.1.直接输出日志
        logger.info("hello jul");
        //2.2.设置级别 输出日志
        logger.log(Level.INFO, "level info msg");
        //2.3.通过占位符方式 输出变量值
        String msg = "hello world";
        Integer num = 123;
        logger.log(Level.INFO, "user message:{0}, {1}", new Object[]{msg, num});
    }

    @Test
    public void testLogLevel(){
        //1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.stone.JULTest");
        //2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");//默认日志输出级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogConfig() throws IOException {
        //1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.stone.JULTest");

        //1.1.关闭系统默认配置
        logger.setUseParentHandlers(false);

        //1.2.自定义配置日志级别（关联处理器&转换器）
        //1.2.1.创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //1.2.2.创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //1.2.3.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        //1.3.设置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //场景FileHandler 文件输出
        FileHandler fileHandler = new FileHandler("D:/logs/jul.log");
        //进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        //2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");//默认日志输出级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogParent(){
        Logger loggerChild = Logger.getLogger("com.stone");
        Logger loggerParent = Logger.getLogger("com");
        //默认按照 命名目录层级关系 来设置父子关系
        System.out.println(loggerParent == loggerChild.getParent());//true
        //所有日志记录器的顶级父元素 LogManager$RootLogger，默认的name：""。
        System.out.println("loggerParent's default parent: " + loggerParent.getParent() + ", name: "
        + loggerParent.getParent().getName());

        //1.1.关闭系统默认配置
        loggerParent.setUseParentHandlers(false);

        //1.2.自定义配置日志级别（关联处理器&转换器）
        //1.2.1.创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //1.2.2.创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //1.2.3.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        loggerParent.addHandler(consoleHandler);

        //1.3.设置日志具体级别
        loggerParent.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //2.日志记录输出
        //loggerChild会按照loggerParent设置的日志级别输出对应的日志
        loggerChild.severe("severe");
        loggerChild.warning("warning");
        loggerChild.info("info");//默认日志输出级别
        loggerChild.config("config");
        loggerChild.fine("fine");
        loggerChild.finer("finer");
        loggerChild.finest("finest");
    }

    //加载自定义配置文件
    @Test
    public void testLogProperties() throws IOException {
        //1.通过类加载器 读取配置文件
        InputStream inputStream = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        //2.创建LogManager
        LogManager logManager = LogManager.getLogManager();
        //3.通过LogManger加载配置文件
        logManager.readConfiguration(inputStream);

        //创建日志记录器
        Logger logger = Logger.getLogger("com.stone.JULTest");
        //日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");//默认日志输出级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        //创建日志记录器
        Logger loggerTest = Logger.getLogger("test.JULTest");
        //日志记录输出
        loggerTest.severe("severe test");
        loggerTest.warning("warning test");
        loggerTest.info("info test");//默认日志输出级别
        loggerTest.config("config test");
        loggerTest.fine("fine test");
        loggerTest.finer("finer test");
        loggerTest.finest("finest test");
    }
}

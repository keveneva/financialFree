//package com.sun.demo;
//
//import org.apache.log4j.Logger;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//
///**
// * 采用本地tomcat启动 所必须的配置文件 不能与demoApplication共存
// */
//@SpringBootApplication
//@ServletComponentScan
////@ComponentScan(basePackages = {"com.sun"})
//@MapperScan("com.sun.demo.sys.dao")
//public class ServerApplication extends SpringBootServletInitializer implements CommandLineRunner {
//
//    private final Logger logger = Logger.getLogger(ServerApplication.class);
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(ServerApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ServerApplication.class, args);
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        logger.info("项目启动完成！------------------");
//    }
//}
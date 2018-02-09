package com.sun.demo;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 用于 手动启动项目，采用springboot自带的tomcat
 *一个项目中只能存在一个SpringBootApplication 用这个就必须注释掉serverApplication，不然启动报错
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.sun.demo.sys.dao")
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner{

    private final Logger logger = Logger.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    // Java EE应用服务器配置，
    // 如果要使用tomcat来加载jsp的话就必须继承SpringBootServletInitializer类并且重写其中configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    // springboot运行后此方法首先被调用
    // 实现CommandLineRunner抽象类中的run方法
    @Override
    public void run(String... args) throws Exception {
        logger.info("项目启动完成！");
    }
}

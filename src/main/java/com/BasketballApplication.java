package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 徐晓瑞
 * @date 2022/8/29 17:14
 * @describe:
 */
@SpringBootApplication
@MapperScan("com.*.mapper")
public class BasketballApplication {

    private final static Logger logger = LoggerFactory.getLogger(BasketballApplication.class);

    /**
     * springboot启动
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("druid.mysql.usePingMethod", "false");
        ConfigurableApplicationContext run = SpringApplication.run(BasketballApplication.class, args);
        Environment bean = run.getBean(Environment.class);
        String port = bean.getProperty("server.port");
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            logger.info("\n" +
                    " :: 本地访问地址 : http://localhost:" + port + "\n" +
                    " :: 局域网访问地址 : http://"+ addr.getHostAddress() + ":" + port + "\n" +
                    " :: 数据监控地址 : http://"+ addr.getHostAddress() + ":" + port + "/druid\n" +
                    " :: 公网访问地址 : 暂无");
        } catch (UnknownHostException  e) {
            System.err.println(e.getMessage());
        }
    }
}

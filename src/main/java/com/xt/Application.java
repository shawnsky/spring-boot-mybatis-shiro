package com.xt; /**
 * Created by Administrator on 2017/7/5.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 07-05 16:32
 * 服务启动类
 * @author xt
 **/

@SpringBootApplication
@MapperScan("com.xt.mapper")
public class Application implements EmbeddedServletContainerCustomizer {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8080);
    }

}

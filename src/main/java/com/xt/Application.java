package com.xt; /**
 * Created by Administrator on 2017/7/5.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 07-05 16:32
 *
 * @author xt
 **/

@SpringBootApplication
@MapperScan("com.xt.mapper")
public class Application {

//    /**
//     * Character encoding filter filter registration bean.
//     * 编码过滤器
//     * @return the filter registration bean
//     */
//    @Bean(name = "characterEncodingFilter")
//    public FilterRegistrationBean characterEncodingFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.addInitParameter("encoding","UTF-8");
//        bean.addInitParameter("forceEncoding", "ture");
//        bean.setFilter(new CharacterEncodingFilter());
//        bean.addUrlPatterns("/*");
//        return bean;
//    }


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}

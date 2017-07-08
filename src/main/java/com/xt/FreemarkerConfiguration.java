package com.xt;/**
 * Created by Administrator on 2017/7/6.
 */

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * 07-06 17:17
 * freemarker 配置类
 * @author xt
 **/
@org.springframework.context.annotation.Configuration
public class FreemarkerConfiguration implements InitializingBean{

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void afterPropertiesSet() throws Exception {
        freeMarkerConfigurer.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
}

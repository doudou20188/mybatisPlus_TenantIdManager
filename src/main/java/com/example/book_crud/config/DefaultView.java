package com.example.book_crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description: 配置启动默认跳转页面
 *
 * @author yangtao3@shein.com
 * @date 2023/1/28 4:36 PM
 */

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        //主页
        registry.addViewController("/").setViewName("forward:/pages/books.html");
    }


}

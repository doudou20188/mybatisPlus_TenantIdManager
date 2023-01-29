package com.example.book_crud.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.example.book_crud.config.talent.TenantIdManager;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig{

    /* 租户ID管理器 */
    @Autowired
    private TenantIdManager tenantIdManager;


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //定义mapper拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //多租户插件
        TenantLineInnerInterceptor tenantInterceptor = new TenantLineInnerInterceptor();
        tenantInterceptor.setTenantLineHandler(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                // 返回当前用户的租户ID
                return new LongValue(tenantIdManager.getCurrentTenantId());
            }
        });


        //根据需求，添加需要的MP拦截器
        //1分页插件
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //2.多租户ID插件
        interceptor.addInnerInterceptor(tenantInterceptor);
        return interceptor;
    }
}

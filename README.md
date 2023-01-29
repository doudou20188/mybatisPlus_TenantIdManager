[//]: # (# SpringBoot-Demo-CRUD)

[//]: # (课程地址：https://www.bilibili.com/video/BV15b4y1a7yG?share_source=copy_web  )

[//]: # (文档说明：https://www.yuque.com/docs/share/4982b5b4-9a61-46f0-816e-cc0f6ba0d3d0?# 《简单的CRUD案例》  )

[//]: # (代码对应P29-P50，删除了冗余部分代码，命名有些不一样。)

[//]: # (## 数据库文件)

[//]: # (db/文件夹下)

[//]: # (### 项目预览图)

[//]: # (![preview]&#40;https://raw.githubusercontent.com/SiQuan-Wen/SpringBoot-Demo-CRUD/master/images/preview.jpeg&#41;)

这是一个小样例子，可以拉下来单独启动，需要执行DB的SQL配置

### 1.项目启动
[启动1](http://localhost:8080)
[启动2](http://localhost:8080/pages/books.html)
都是可以的，第一种是配置的默认跳转页 -> DefaultView.java
### 2.具体配置多租户
- 2.1 TenantIdManager 设置当前系统登陆租户ID
- 2.2 MybatisPlusConfig 配置多租户拦截器
- 2.3 com.example.book_crud.controller.BookController.queryAll  设置租户ID，查询验证
==>  Preparing: SELECT id, type, name, description FROM tbl_book WHERE tenant_id = 233
是看到拼接了，实际CRUD都会拼接，特殊不拼接，需要额外设置拦截处理，XML应该是没有拦截的，这个待验证。

- 2.4 关于多租户不需要拦截表的配置待补充TODO
可以选择配置或者注解模式

### 3.实现参考
https://www.hxstrive.com/subject/mybatis_plus.htm?id=311
https://baomidou.com/pages/aef2f2/#tenantlineinnerinterceptor

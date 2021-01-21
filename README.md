<p align="center">
    <br>      
    <br>      
    <p align="center">
        Ods-Separation |sepəˈreɪʃn| 蕴意为分离版本。<br/>
        项目采用前后端分离架构，代码简洁，功能丰富，开箱即用，开创快速开发平台新趋势<br/>
        <br>
        <a href="https://www.antdv.com/docs/vue/introduce-cn/">
            <img src="https://img.shields.io/badge/vue--ant--design-2.1.0-blue.svg" alt="bootstrap">
        </a> 
        +
        <a href="http://spring.io/projects/spring-boot">
            <img src="https://img.shields.io/badge/spring--boot-2.3.1-green.svg" alt="spring-boot">
        </a>
        <a href="http://mp.baomidou.com">
            <img src="https://img.shields.io/badge/mybatis--plus-3.3.2-blue.svg" alt="mybatis-plus">
        </a>  
    </p>
</p>

### 快速开始

准备以下环境：
1. yarn，jdk1.8，maven 3.6或以上版本。
2. 需要准备一个mysql 5.7数据库。
3. 您的IDE需要安装lombok插件。

前端运行：
1. cd _web/
2. yarn
3. yarn serve

后端运行：
1. 将数据库文件_sql/guns-separation.sql导入到数据库
2. 修改ods-main/src/main/resources/application-local.yml文件，修改为您的数据库ip，账号和密码
3. 运行guns-main/src/main/java/cn/stylefeng/guns/GunsApplication类，即可启动后端程序


1. 模块化架构设计，层次清晰，业务层推荐写到单独模块，方便升级。
2. 前后端分离架构，分离开发，分离部署，前后端互不影响。
3. 前端技术采用vue + antdv + axios。
3. 后端采用spring boot + mybatis-plus + hutool等，开源可靠。
4. 基于spring security(jwt) + 用户UUID双重认证。
5. 基于AOP实现的接口粒度的鉴权，最细粒度过滤权限资源。
6. 基于hibernate validator实现的校验框架，支持自定义校验注解。
7. 提供Request-No的响应header快速定位线上异常问题。
8. 在线用户可查，可在线踢人，同账号登录可同时在线，可单独在线（通过系统参数配置）。
9. 支持前端 + 后端在线代码生成（后续开放）。
10. 支持jenkins一键部署，另自带docker maven插件，支持docker部署。
11. 文件，短信，缓存，邮件等，利用接口封装，方便拓展。
12. 文件默认使用本地文件，短信默认使用阿里云sms，缓存默认使用内存缓存。

### 功能介绍

1. 主控面板。控制台页面，可进行工作台，分析页，统计等功能的展示。
2. 用户管理。对企业用户和系统管理员用户的维护，可绑定用户职务，机构，角色，数据权限等。
3. 应用管理。通过应用来控制不同维度的菜单展示。
4. 机构管理。公司组织架构维护，支持多层级结构的树形结构。
5. 职位管理。用户职务管理，职务可作为用户的一个标签，职务目前没有和权限等其他功能挂钩。
6. 菜单管理。菜单目录，菜单，和按钮的维护是权限控制的基本单位。
7. 角色管理。角色绑定菜单后，可限制相关角色的人员登录系统的功能范围。角色也可以绑定数据授权范围。
8. 字典管理。系统内各种枚举类型的维护。
9. 访问日志。用户的登录和退出日志的查看和管理。
10. 操作日志。用户的操作业务的日志的查看和管理。
11. 服务监控。服务器的运行状态，Java虚拟机信息，jvm等数据的查看。
12. 在线用户。当前系统在线用户的查看。
13. 数据监控。druid控制台功能，可查看sql的运行信息。
14. 公告管理。系统的公告的管理。
15. 文件管理。文件的上传下载查看等操作，文件可使用本地存储，阿里云oss，腾讯cos接入，支持拓展。
16. 定时任务。定时任务的维护，通过cron表达式控制任务的执行频率。
17. 系统配置。系统运行的参数的维护，参数的配置与系统运行机制息息相关。
18. 邮件发送。发送邮件功能。
19. 短信发送。短信发送功能，可使用阿里云sms，腾讯云sms，支持拓展。


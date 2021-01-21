/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package cn.stylefeng.guns.sys.config;

import cn.stylefeng.guns.sys.core.mybatis.dbid.GunsDatabaseIdProvider;
import cn.stylefeng.guns.sys.core.mybatis.fieldfill.CustomMetaObjectHandler;
import cn.stylefeng.guns.sys.core.mybatis.sqlfilter.DemoProfileSqlInterceptor;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis扩展插件配置
 *
 * @author xuyuxiang, fengshuonan
 * @date 2020/3/18 10:49
 */
@Configuration
@MapperScan(basePackages = {"cn.stylefeng.guns.**.mapper"})
public class MybatisConfig {

    /**
     * mybatis-plus分页插件
     *
     * @author xuyuxiang
     * @date 2020/3/31 15:42
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 演示环境的sql拦截器
     * <p>
     * 演示环境只开放查询操作，其他都不允许
     *
     * @author stylefeng
     * @date 2020/5/5 12:24
     */
    @Bean
    public DemoProfileSqlInterceptor demoProfileSqlInterceptor() {
        return new DemoProfileSqlInterceptor();
    }

    /**
     * 自定义公共字段自动注入
     *
     * @author xuyuxiang
     * @date 2020/3/31 15:42
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new CustomMetaObjectHandler();
    }

    /**
     * 数据库id选择器
     *
     * @author stylefeng
     * @date 2020/6/20 21:23
     */
    @Bean
    public GunsDatabaseIdProvider gunsDatabaseIdProvider() {
        return new GunsDatabaseIdProvider();
    }

}

package com.lh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket createDocket(){
        return  new Docket(DocumentationType.SWAGGER_2)
                //添加api基本信息
                .apiInfo(apiInfo())
                //对基本信息进行查询
                .select()
                //扫描指定包下的所有swagger注解
                .apis(RequestHandlerSelectors.basePackage("com.lh"))
                //支持的路径(任意路径)
                .paths(PathSelectors.any())
                //构建
                .build();
    }
    private ApiInfo apiInfo(){
        return new  ApiInfoBuilder()
                //api标题
                .title("Swagger测试")
                //描述
                .description("第一次使用Swagger")
                //联系人(作者的联系方式)
                .contact(new Contact("foerrBom","http://baidu.com","2312697938"))
                //版本号
                .version("1.0")
                //许可证
                .license("Apache 2.0")
                //服务条款
                .termsOfServiceUrl("http//swagger.io")
                .build();
    }
}

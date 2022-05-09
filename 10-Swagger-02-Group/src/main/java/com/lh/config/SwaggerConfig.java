package com.lh.config;//package com.lh.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//@Configuration
////开启Swagger2
////@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket docket1(){
//        return  new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//
//    @Bean
//    public Docket docket2(){
//        return  new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }
//    @Bean
//    public Docket docket3(){
//        return  new Docket(DocumentationType.SWAGGER_2).groupName("C");
//    }
//
//
//    //配置了Swagger的Docket的bean实例
//    @Bean
//    public Docket docket(Environment environment) {
//
//        //设置要显示的swagger的环境
//        Profiles profiles = Profiles.of("dev","test");
//        //通过environment.acceptsProfiles判断是否处在直接的环境中
//        boolean flag = environment.acceptsProfiles(profiles);
//        System.out.println(flag);
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("李豪")
//                //是否启用Swagger, 如果是false 则swagger不能在浏览器上访问
//                .enable(true)
//                .select()
//                //RequestHandlerSelectors,需要扫描接口的方式
////              basePackage 指定扫描的包
//                //any()：扫描全部
//                //none():都不扫描
//                //withClassAnnotation: 扫描类上的注解
//                // withMethodAnnotation  扫描包上的注解
//                .apis(RequestHandlerSelectors.basePackage("com.lh.controller"))
//                //过滤路径
////                .paths(PathSelectors.ant("/lh/**"))
//                .build();
//    }
//
//    //配置swagger信息=apiInfo
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact("李豪", "http://baidu.com", "23122323.com");
//
//        return new ApiInfo("李豪的Swagger",
//                "学通", "1.0",
//                "http://baidu.com",
//                contact,
//                "Apache 2.0",
//                "Http://lh",
//                new ArrayList<>());
//    }
//}

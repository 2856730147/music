package com.lh.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

//@Configuration
public class YmlConfig {
    //加载yml格式的自定义配置文件
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();


        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();

        factoryBean.setResources(new ClassPathResource("person.yml"));

        configurer.setProperties(factoryBean.getObject());

        return configurer;
    }
}

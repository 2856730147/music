package com.lh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LENOVO
 */
@ComponentScan("com.lh")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AopConfig {


}

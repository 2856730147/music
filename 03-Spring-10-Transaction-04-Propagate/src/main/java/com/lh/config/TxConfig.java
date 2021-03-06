package com.lh.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lh.dao.AccountDao;
import com.lh.dao.LocationDao;
import com.lh.dao.impl.AccountDaoImpl;
import com.lh.dao.impl.LocationDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author LENOVO
 */
@PropertySource("classpath:jdbc.properties")
//指定包扫描路径，会扫描指定包下的所以注解
@ComponentScan("com.lh")
/**
 * 当前类是配置文件
 */
@Configuration
public class TxConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String  username;
    @Value("${jdbc.password}")
    private String password;
    /**
     *id就是方法名
     */
@Bean
    public DataSource dataSource(){
    Properties properties = new Properties();
    properties.setProperty("drverClassName",driverClassName);
    properties.setProperty("url",url);
    properties.setProperty("username",username);
    properties.setProperty("password",password);
    DataSource dataSource=null;
    try {
        //通过数据源工厂获取数据源并且加载Properties中的配置
        dataSource = DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dataSource;
    }
    @Bean
    public LocationDao locationDao(DataSource dataSource){
        LocationDaoImpl locationDao = new LocationDaoImpl();
        locationDao.setDataSource(dataSource);
        return locationDao;
    }
    @Bean
    public AccountDao accountDao(DataSource dataSource){
        AccountDaoImpl accountDao = new AccountDaoImpl();

        accountDao.setDataSource(dataSource);

        return accountDao;
    }
}

package com.davis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Davis
 * @date 2021-11-09 - 10:04
 * @description
 */
@Configuration
@ComponentScan(value = "com.davis",excludeFilters = {@ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class, Configuration.class })})
@EnableAspectJAutoProxy
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.davis.DAO")
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer newPropertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(value = "dataSource")
    @Lazy(false)
    public DataSource dataSource(@Value("${mysql.driver}") String driverClass, @Value("${mysql.url}") String jdbcUrl,
                                 @Value("${mysql.username}") String username, @Value("${mysql.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        //数据源的名称和密码等等
        System.setProperty("druid.mysql.usePingMethod","false");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //设置连接的url
        dataSource.setUrl(jdbcUrl);
        //设置连接的驱动
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml");
        factoryBean.setMapperLocations(mapperLocations);
        factoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration con = new org.apache.ibatis.session.Configuration();
        con.setMapUnderscoreToCamelCase(true);
        con.setCacheEnabled(true);
        con.setUseActualParamName(true);
        con.setAggressiveLazyLoading(false);

        factoryBean.setConfiguration(con);
        return factoryBean.getObject();
    }

    @Bean("txManager") // 需要在最顶端用注解@Enable来启用事物管理器
    public DataSourceTransactionManager newData(DataSource dataSource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource);
        return dstm;
    }
    @Bean("mailSender")
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername("1326869514@qq.com");
        javaMailSender.setPassword("gfsdycfawryxiegi");
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.from", "1326869514@qq.com");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }


}





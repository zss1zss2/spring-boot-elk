package com.zss.api.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DruidConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource resource = new ClassPathResource("mybatis-config.xml", getClass().getClassLoader());
        sqlSessionFactoryBean.setConfigLocation(resource);
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("init sqlSessionFactory failed : {}", e.toString(), e);
        }
        return sqlSessionFactory;
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }


}

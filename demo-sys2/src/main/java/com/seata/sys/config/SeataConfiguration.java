package com.seata.sys.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
public class SeataConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean( DataSource dataSource) throws IOException {
        // 这里用 MybatisSqlSessionFactoryBean 代替了 SqlSessionFactoryBean，否则 MyBatisPlus 不会生效
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/dao/*/*.xml"));
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        return mybatisSqlSessionFactoryBean;
    }

}

package com.seata.sys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: Mybatis-Plus配置文件
 *
 */
@Configuration
@MapperScan("com.seata.sys.dao.*")
public class MybatisPlusConfig {
}

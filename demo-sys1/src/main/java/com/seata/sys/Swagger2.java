package com.hellotax.sys;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liqiao
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.basePackage}")
    private String basePackage;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        /**
         * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
         * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
         * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
         * 并产生文档内容（除了被@ApiIgnore指定的请求）
         */
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(basePackage))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }
}
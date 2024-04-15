package com.bytebam.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(
        prefix = "springdoc.api-docs")
@Getter
@Setter
public class DocProperties {
    /*
     * 文档标题
     */
    private String title;
    /*
     * 文档描述
     */
    private String description;
    /*
     * 文档版本
     */
    private String version;
    /*
     * 文档访问url
     */
    private String url;
    /*
     * 文档名字
     */
    private String name;
    /*
     * 邮箱
     */
    private String email;
    /*
     * 作者
     */
    private String author;
}

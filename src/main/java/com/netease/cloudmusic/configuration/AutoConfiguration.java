package com.netease.cloudmusic.configuration;

import com.netease.cloudmusic.properties.DocProperties;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@ConditionalOnProperty(prefix = "springdoc.api-docs",
        name = {"enabled"},
        havingValue = "true"
)
public class AutoConfiguration {

    private final DocProperties properties;

    public AutoConfiguration(DocProperties properties) {
        this.properties = properties;
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation()
                        .description(properties.getDescription())
                        .url(properties.getUrl())
                );
    }

    private Info apiInfo() {
        return new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(new Contact()
                        .name(properties.getAuthor())
                        .url(properties.getUrl())
                        .email(properties.getEmail()
                        ))
                .license(new License()
                        .name("许可协议")
                        .url("www.bytebam.com")
                );
    }

}


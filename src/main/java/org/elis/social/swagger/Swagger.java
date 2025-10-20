package org.elis.social.swagger;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(
                        new SecurityRequirement().addList("Bearer Authentication")
                )
                .components(
                        new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme())
                )
                .info(
                        new Info()
                                .title("Social Network API")
                                .description("API per Social Network")
                                .version("1.0")
                                .contact(
                                        new Contact()
                                                .name("Filippo")
                                                .email("filippo@edu.elis.org")
                                                .url("https://github.com/filo99-dev")
                                )
                                .extensions(Map.of(
                                        "x-contacts", List.of(
                                                Map.of(
                                                        "name", "Filippo",
                                                        "email", "filippo@edu.elis.org"
                                                )
                                        )
                                ))
                                .license(new License().name("Copiright (C) 2025 Social Network"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Production Server"),
                        new Server().url("http://localhost:8080").description("Development Server")
                ));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

}

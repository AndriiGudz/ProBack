package de.ait.shop41.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Shop Application",
                description = "Application on-line",
                version = "0.1.1",
                contact = @Contact(
                        name = "Andrii",
                        email = "andrii@mail.com"

                )
        )
)
public class SwaggerConfiguration {
}

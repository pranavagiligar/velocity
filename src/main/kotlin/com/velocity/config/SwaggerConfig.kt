package com.velocity.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.BasicAuth
import springfox.documentation.service.SecurityReference
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.SecurityConfiguration
import springfox.documentation.swagger.web.SecurityConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()

//    @Bean
//    open fun api(): Docket {
//        val securityReference = SecurityReference.builder()
//            .reference("basicAuth")
//            .scopes(arrayOfNulls(0))
//            .build()
//        val reference = ArrayList<SecurityReference>(1)
//        reference.add(securityReference)
//        val securityContexts: ArrayList<SecurityContext> = ArrayList<SecurityContext>(1)
//        securityContexts.add(SecurityContext.builder().securityReferences(reference).build())
//        val auth = ArrayList<SecurityScheme>(1)
//        auth.add(BasicAuth("bearerAuth"))
//        return Docket(DocumentationType.SWAGGER_2)
//            .securitySchemes(auth)
//            .securityContexts(securityContexts)
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//    }
}
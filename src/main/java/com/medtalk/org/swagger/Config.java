//package com.medtalk.org.swagger;
//
//
//import com.medtalk.org.controllers.*;
//import com.medtalk.org.entity.Category;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@EnableSwagger2
//@Configuration
//@ComponentScan(basePackageClasses = {
//        CategoryController.class, CommentController.class, PostController.class, UserController.class, JwtController.class})
//public class Config {
//
//    @Bean
//    public Docket api() {
//            Set<String> responseProduceType = new HashSet<String>();
//            responseProduceType.add("application/json");
//            responseProduceType.add("application/xml");
//
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                    .paths(PathSelectors.any()).build()
//                    .useDefaultResponseMessages(false)
//                    .genericModelSubstitutes(ResponseEntity.class)
//                    .produces(responseProduceType)
//                    .consumes(responseProduceType)
//                    .apiInfo(apiInfo());
//
//    }
//
//
//
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Developer Box")
//                .description("Restfull web documentation using swagger")
//                .termsOfServiceUrl("https://www.blogging.com")
//                .license("code license")
//                .licenseUrl("https://www.facebook.com")
//                .contact(new Contact("Ayasa","www.ayasa.com","ayasa@gmail.com"))
//                .version("3.0")
//                .build();
//
//
//    }
//
//
//
//
//
//}

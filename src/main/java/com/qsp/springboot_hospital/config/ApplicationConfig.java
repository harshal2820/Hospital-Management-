package com.qsp.springboot_hospital.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Url of Swagger : http://localhost:8080/swagger-ui.html#
@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		Contact contact= new Contact("Harshal Valeha","www.google.com","h@gmail.com");
		
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo=new  ApiInfo("Hospital Management System","manages Hospital","Version 20.0","1 year fukat", contact,"QSP001","www.mitaaldhodi.clom", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_hospital")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
		
		
	}
	
}

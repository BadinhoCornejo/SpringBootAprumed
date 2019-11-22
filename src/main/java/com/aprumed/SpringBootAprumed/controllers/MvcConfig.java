package com.aprumed.SpringBootAprumed.controllers;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/notFound").setViewName("404");
    }

    @Override
    public void	addCorsMappings(CorsRegistry registry){
		registry.
				addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("*")
				.allowedMethods("GET", "POST","PUT", "OPTIONS")
				.allowCredentials(true);
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
	    return container -> {
	        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
	                "/notFound"));
	    };
	  }
	
}

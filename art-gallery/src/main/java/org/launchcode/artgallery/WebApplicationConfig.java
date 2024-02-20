package org.launchcode.artgallery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean // makes it a Spring-managed class
    public AuthenticationFilter authenticationFilter() {
        // Create object that will allow app to access filter
        return new AuthenticationFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register filter with Spring so it will intercept requests
        registry.addInterceptor( authenticationFilter() );
    }
}

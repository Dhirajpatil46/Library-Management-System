package com.pack1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootMvcWithThymleafApplication extends SpringBootServletInitializer 
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) 
    {
        return builder.sources(SpringBootMvcWithThymleafApplication.class);
    }

    public static void main(String[] args) 
    {
        SpringApplication.run(SpringBootMvcWithThymleafApplication.class, args);
        System.out.println("Hello World");
    }
}

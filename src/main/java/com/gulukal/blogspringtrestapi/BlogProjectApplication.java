package com.gulukal.blogspringtrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Gulten Ulukal
 */

@SpringBootApplication
public class BlogProjectApplication {
    //to use modelMapper lib.
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogProjectApplication.class, args);
    }

}

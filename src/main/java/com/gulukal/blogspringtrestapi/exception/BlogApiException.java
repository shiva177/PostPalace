package com.gulukal.blogspringtrestapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Gulten Ulukal
 */

@Getter
@AllArgsConstructor

public class BlogApiException extends RuntimeException{

    private HttpStatus status;
    private String massage;

}

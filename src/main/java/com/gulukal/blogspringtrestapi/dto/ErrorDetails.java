package com.gulukal.blogspringtrestapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor

public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}

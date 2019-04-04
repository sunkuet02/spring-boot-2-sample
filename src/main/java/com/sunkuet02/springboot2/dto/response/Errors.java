package com.sunkuet02.springboot2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Errors {
    private Integer code;

    private String description;
}

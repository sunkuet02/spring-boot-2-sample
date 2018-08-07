package com.sunkuet02.springboot2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T> {
    Metadata metadata;

    T data;
}

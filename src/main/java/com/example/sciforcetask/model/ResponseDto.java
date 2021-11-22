package com.example.sciforcetask.model;

import lombok.Data;

@Data
public class ResponseDto {
    private String productUuid;
    private String productName;
    private Integer amount;
}

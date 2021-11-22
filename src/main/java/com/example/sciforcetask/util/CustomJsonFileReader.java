package com.example.sciforcetask.util;

import com.example.sciforcetask.model.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class CustomJsonFileReader {
    private final ObjectMapper objectMapper;

    public CustomJsonFileReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseDto[] read(String path) {
        try {
            return objectMapper.readValue(new File(path), ResponseDto[].class);
        } catch (IOException e) {
            throw new RuntimeException("Can't read json from file: " + path);
        }
    }
}

package com.example.sciforcetask.dao;

import com.example.sciforcetask.model.ResponseDto;
import java.util.Map;

public interface CustomSimpleDao {
    void saveOrUpdate(ResponseDto[] dtos);

    Map<String, ResponseDto> getAll();
}

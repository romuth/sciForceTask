package com.example.sciforcetask.service;

import java.util.List;
import com.example.sciforcetask.model.ResponseDto;

public interface SimpleDaoService {
    void saveOrUpdate(ResponseDto[] dtos);

    List<ResponseDto> getAll();
}

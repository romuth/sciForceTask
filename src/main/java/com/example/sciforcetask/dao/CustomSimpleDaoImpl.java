package com.example.sciforcetask.dao;

import com.example.sciforcetask.model.ResponseDto;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomSimpleDaoImpl implements CustomSimpleDao {
    private static final Map<String, ResponseDto> storage = new HashMap<>();

    @Override
    public void saveOrUpdate(ResponseDto[] dtos) {
        for (ResponseDto dto : dtos) {
            if (storage.containsKey(dto.getProductUuid())) {
                ResponseDto responseDto = storage.get(dto.getProductUuid());
                responseDto.setAmount(responseDto.getAmount() + dto.getAmount());
            } else {
                storage.put(dto.getProductUuid(), dto);
            }
        }
    }

    @Override
    public Map<String, ResponseDto> getAll() {
        return storage;
    }
}

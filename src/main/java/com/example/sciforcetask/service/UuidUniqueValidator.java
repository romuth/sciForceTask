package com.example.sciforcetask.service;

import com.example.sciforcetask.exception.UniqueUuidException;
import com.example.sciforcetask.model.ResponseDto;
import java.util.Arrays;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UuidUniqueValidator implements Predicate<ResponseDto[]> {

    @Override
    public boolean test(ResponseDto[] dtos) {
        if (dtos.length == Arrays.stream(dtos)
                .map(ResponseDto::getProductUuid)
                .distinct().count()) {
            return true;
        }
        throw new UniqueUuidException("Some product ids have the same value");
    }
}

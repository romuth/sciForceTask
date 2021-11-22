package com.example.sciforcetask.controller;

import com.example.sciforcetask.dao.CustomSimpleDao;
import com.example.sciforcetask.model.ResponseDto;
import com.example.sciforcetask.util.CustomHttpClient;
import com.example.sciforcetask.util.CustomJsonFileReader;
import com.example.sciforcetask.util.UuidUniqueValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {
    private final UuidUniqueValidator validator;
    private final CustomSimpleDao dao;
    private final CustomHttpClient httpClient;
    private final CustomJsonFileReader reader;

    public InputController(UuidUniqueValidator validator, CustomSimpleDao dao,
                           CustomHttpClient httpClient, CustomJsonFileReader reader) {
        this.validator = validator;
        this.dao = dao;
        this.httpClient = httpClient;
        this.reader = reader;
    }

    @GetMapping("/products")
    public ResponseDto[] getListOfProducts(@RequestParam String url, @RequestParam String path) {
        ResponseDto[] dtos = httpClient.get(url);
        ResponseDto[] read = reader.read(path);
        validator.test(dtos);
        validator.test(read);
        dao.saveOrUpdate(dtos);
        dao.saveOrUpdate(read);
        return dao.getAll().values().toArray(new ResponseDto[0]);
    }
}

package com.example.sciforcetask.controller;

import com.example.sciforcetask.dao.CustomSimpleDao;
import com.example.sciforcetask.model.ResponseDto;
import com.example.sciforcetask.service.SimpleDaoService;
import com.example.sciforcetask.util.CustomHttpClient;
import com.example.sciforcetask.util.CustomJsonFileReader;
import com.example.sciforcetask.service.UuidUniqueValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InputController {
    private final UuidUniqueValidator validator;
    private final SimpleDaoService service;
    private final CustomHttpClient httpClient;
    private final CustomJsonFileReader reader;

    public InputController(UuidUniqueValidator validator, SimpleDaoService service,
                           CustomHttpClient httpClient, CustomJsonFileReader reader) {
        this.validator = validator;
        this.service = service;
        this.httpClient = httpClient;
        this.reader = reader;
    }

    @GetMapping("/products")
    public List<ResponseDto> getListOfProducts(@RequestParam String url, @RequestParam String path) {
        ResponseDto[] dtos = httpClient.get(url);
        ResponseDto[] read = reader.read(path);
        validator.test(dtos);
        validator.test(read);
        service.saveOrUpdate(dtos);
        service.saveOrUpdate(read);
        return service.getAll();
    }
}

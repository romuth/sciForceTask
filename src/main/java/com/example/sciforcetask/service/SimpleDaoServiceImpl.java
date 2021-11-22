package com.example.sciforcetask.service;

import com.example.sciforcetask.dao.CustomSimpleDao;
import com.example.sciforcetask.model.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleDaoServiceImpl implements SimpleDaoService {
    private final CustomSimpleDao dao;

    public SimpleDaoServiceImpl(CustomSimpleDao dao) {
        this.dao = dao;
    }

    @Override
    public void saveOrUpdate(ResponseDto[] dtos) {
        dao.saveOrUpdate(dtos);
    }

    @Override
    public List<ResponseDto> getAll() {
        return new ArrayList<>(dao.getAll().values());
    }
}

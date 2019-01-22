package com.rdxer.springjpa.service.impl;

import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.repository.RecordRepository;
import com.rdxer.springjpa.service.RecordService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordRepository recordRepository;

    public Record show(Long id){
        Optional<Record> byId = recordRepository.findById(id);
        if (byId.isEmpty()){
            System.out.println("Optional<Record> byId = recordRepository.findById(id); == null");
            return null;
        }
        return byId.get();
    }

    public Record save(Record model){
        return recordRepository.saveAndFlush(model);
    }

    @Override
    public List<Record> getAll() {
        return recordRepository.findAll();
    }
}

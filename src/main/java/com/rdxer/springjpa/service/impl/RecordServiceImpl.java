package com.rdxer.springjpa.service.impl;

import com.rdxer.springjpa.exception.exceptions.BadRequestException;
import com.rdxer.springjpa.exception.exceptions.NotAcceptableException;
import com.rdxer.springjpa.exception.exceptions.NotFoundException;
import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.repository.RecordRepository;
import com.rdxer.springjpa.service.RecordService;
import com.rdxer.springjpa.util.Util;
import org.springframework.beans.BeanUtils;
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
            throw new NotFoundException();
        }
        return byId.get();
    }

    public void destroy(Long id) {
        boolean b = recordRepository.existsById(id);
        if (b == false){
            throw new NotFoundException();
        }
        recordRepository.deleteById(id);
    }

    @Override
    public Record store(Record model) {
        return recordRepository.saveAndFlush(model);
    }

    @Override
    public Record updateOfPatch(Long id,Record model) {

        if (model.getId() != null && model.getId() != id) {
            System.out.println("error： 400");
            return null;
        }

        Optional<Record> r = recordRepository.findById(id);
        if (r.isEmpty()){
            throw new NotFoundException();
        }

        model.setId(id);
        //支持部分更新
        String[] nullPropertyNames = Util.getNullPropertyNames(model);
        BeanUtils.copyProperties(model,r.get(), nullPropertyNames);

        return recordRepository.save(r.get());
    }

    @Override
    public Record update(Long id,Record model) {
        if (model.getId() != null && model.getId() != id) {
            throw new NotAcceptableException();
        }
        model.setId(id);
        return recordRepository.save(model);
    }

    @Override
    public List<Record> getAll() {
        return recordRepository.findAll();
    }


}

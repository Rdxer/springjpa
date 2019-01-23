package com.rdxer.springjpa.service;


import com.rdxer.springjpa.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RecordService {
    Record show(Long id);
    void destroy(Long id);
    Record store(Record model);
    Record update(Long id,Record model);
    Record updateOfPatch(Long id, Record model);
    List<Record> getAll();
}

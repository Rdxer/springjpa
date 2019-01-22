package com.rdxer.springjpa.service;


import com.rdxer.springjpa.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RecordService {
    Record show(Long id);
    Record save(Record model);
    List<Record> getAll();
}

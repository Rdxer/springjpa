package com.rdxer.springjpa.api;


import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/api/record")
public class RecordController {

    @Resource
    RecordService recordService;

    @GetMapping("/{id}")
    public Record show(@PathVariable("id") Long id){
        return recordService.show(id);
    }
}

package com.rdxer.springjpa.api;


import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/api/record")
public class RecordController {

    @Resource
    RecordService recordService;

    @GetMapping
    public List<Record> index(){
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    public Record show(@PathVariable("id") Long id){
        return recordService.show(id);
    }

    @PostMapping
    public Record store(@RequestBody Record model){
        return recordService.store(model);
    }

    @PutMapping("/{id}")
    public Record update(@PathVariable("id") Long id,@RequestBody Record model){
        return recordService.update(id,model);
    }

    @PatchMapping("/{id}")
    public Record patchUpdate(@PathVariable("id") Long id,@RequestBody Record model){
        return recordService.updateOfPatch(id,model);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable("id") Long id){
        recordService.destroy(id);
    }

}

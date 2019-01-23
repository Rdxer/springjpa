package com.rdxer.springjpa.api;


import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("信息记录信息管理")
@RestController
@RequestMapping(path = "/api/record")
public class RecordController {

    @Resource
    RecordService recordService;

    @GetMapping
    public List<Record> index() {
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    public Record show(@PathVariable("id") Long id) {
        return recordService.show(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Record store(@RequestBody Record model) {
        return recordService.store(model);
    }

    @ApiOperation(value = "更新记录信息", notes = "会更新所有字段")
    @ApiImplicitParam(name = "model", value = "单个用户信息所有字段", dataType = "Record")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Record update(@PathVariable("id") Long id, @RequestBody Record model) {
        return recordService.update(id, model);
    }

    @ApiOperation(value = "更新记录信息", notes = "只更新非空字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息记录的id", dataType = "Long"),
            @ApiImplicitParam(name = "model", value = "单个用户信息所有字段", dataType = "Record")
    })
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Record patchUpdate(@PathVariable("id") Long id, @RequestBody Record model) {
        return recordService.updateOfPatch(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable("id") Long id) {
        recordService.destroy(id);
    }

}

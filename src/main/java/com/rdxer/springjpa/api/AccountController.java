package com.rdxer.springjpa.api;

import com.rdxer.springjpa.model.Account;
import com.rdxer.springjpa.model.Record;
import com.rdxer.springjpa.service.AccountService;
import com.rdxer.springjpa.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("")
@RestController
@RequestMapping(path = "/api/account")
public class AccountController {

    @Resource
    AccountService service;

    @GetMapping
    public List<Account> index() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Account show(@PathVariable("id") String id) {
        return service.show(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account store(@RequestBody Account model) {
        return service.store(model);
    }

    @ApiOperation(value = "更新", notes = "会更新所有字段")
    @ApiImplicitParam(name = "model", value = "单个所有字段", dataType = "Account")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account update(@PathVariable("id") String id, @RequestBody Account model) {
        return service.update(id, model);
    }

    @ApiOperation(value = "更新记录信息", notes = "只更新非空字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息记录的id", dataType = "String"),
            @ApiImplicitParam(name = "model", value = "单个用户信息所有字段", dataType = "Account")
    })
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account patchUpdate(@PathVariable("id") String id, @RequestBody Account model) {
        return service.updateOfPatch(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable("id") String id) {
        service.destroy(id);
    }

}

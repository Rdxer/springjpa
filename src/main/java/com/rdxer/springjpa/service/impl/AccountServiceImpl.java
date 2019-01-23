package com.rdxer.springjpa.service.impl;

import com.rdxer.springjpa.exception.exceptions.NotFoundException;
import com.rdxer.springjpa.model.Account;
import com.rdxer.springjpa.repository.AccountRepository;
import com.rdxer.springjpa.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository repository;

    @Override
    public Account show(String id) {
        Optional<Account> r = repository.findById(id);
        if (r.isEmpty()){
            throw new NotFoundException();
        }
        return r.get();
    }

    @Override
    public void destroy(String id) {

    }

    @Override
    public Account store(Account model) {
        return repository.save(model);
    }

    @Override
    public Account update(String s, Account model) {
        return null;
    }

    @Override
    public Account updateOfPatch(String s, Account model) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }
}

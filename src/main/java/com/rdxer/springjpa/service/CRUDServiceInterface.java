package com.rdxer.springjpa.service;

import com.rdxer.springjpa.model.Record;

import java.util.List;

public interface CRUDServiceInterface<T, ID> {
    T show(ID id);
    void destroy(ID id);
    T store(T model);
    T update(ID id,T model);
    T updateOfPatch(ID id, T model);
    List<T> getAll();
}


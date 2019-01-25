package com.rdxer.springjpa.repository;

import com.rdxer.springjpa.model.Account;
import com.rdxer.springjpa.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,String> {
    Optional<Account> findByUsername(String username);
}

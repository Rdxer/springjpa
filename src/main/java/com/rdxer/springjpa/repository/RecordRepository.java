package com.rdxer.springjpa.repository;

import com.rdxer.springjpa.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}

package com.lean.tech.demo.employeeapi.repository;

import com.lean.tech.demo.employeeapi.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> { }

package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.model.PositionView;

import java.util.List;

public interface PositionInterface {
    List<PositionView> getAllPositions();
}

package com.lean.tech.demo.employeeapi.controller;

import com.lean.tech.demo.employeeapi.model.PositionView;
import com.lean.tech.demo.employeeapi.service.PositionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {

    @Autowired
    private PositionInterface positionService;

    @GetMapping("/positions")
    private List<PositionView> getAllPositions(){
        return positionService.getAllPositions();
    }
}

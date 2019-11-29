package com.esuv.departmentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by esuv on 2019-11-12
 */
@RestController
public class DepartmentController {

    @GetMapping("departments")
    public ResponseEntity getDepartments() {
        Map<String, List> result = new HashMap<>();
        List<String> departments = new ArrayList<>();
        departments.add("Department 1");
        departments.add("Department 2");
        departments.add("Department 3");
        departments.add("Department 4");
        departments.add("Department 5");
        result.put("departments", departments);

        return ResponseEntity.ok(result);
    }

}

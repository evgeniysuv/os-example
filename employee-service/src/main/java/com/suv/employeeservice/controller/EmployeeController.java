package com.suv.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by esuv on 2019-11-12
 */
@RestController
public class EmployeeController {


    @Value("${microservices.departments.url}")
    private String departmentsUrl;

    @GetMapping(value = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDepartments() {
        System.out.println("Connection to http://departments:8081/department-service/departments");
        String block = WebClient.builder()
                .build()
                .get()
                .uri(departmentsUrl + "/department-service/departments")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class).block();
        return ResponseEntity.ok(block);
    }
}

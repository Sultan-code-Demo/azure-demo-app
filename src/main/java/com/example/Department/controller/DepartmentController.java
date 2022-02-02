package com.example.Department.controller;

import com.example.Department.entity.Department;
import com.example.Department.exception.DataNotFoundException;
import com.example.Department.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find contact by Id",
                  notes = "Given an id finds the department based on the id",
                  response = Department.class)
    public Department getDepartmentById(@ApiParam(value = "Id of the param need to retrieve", required = true) @PathVariable("id") Integer id){
        Department department = departmentService.getDepartmentById(id);
        if (department == null){
            throw new DataNotFoundException("Deparment with id "+id+" not found");
        }
        return department;
    }

}

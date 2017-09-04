package com.sandbox.springstore.springbootspringrestfulstore.controller;

import com.sandbox.springstore.springbootspringrestfulstore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    //@RequestMapping("/employee/{id}")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String employee(@PathVariable Long id, Model model){
        System.out.println("Calling employeeRepository.findOne()");
        model.addAttribute("employee", employeeRepository.findOne(id));
        return "employee";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @ResponseBody
    public String productsList(Model model){
        model.addAttribute("employees", employeeRepository.findAll());

        return "employees";
    }

    /*@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee.getEmployeeId().toString();
    }*/

}

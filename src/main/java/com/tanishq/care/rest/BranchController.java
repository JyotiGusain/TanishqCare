package com.tanishq.care.rest;

import com.tanishq.care.model.Branch;
import com.tanishq.care.model.Student;
import com.tanishq.care.service.BranchService;
import com.tanishq.care.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/branch")
public class BranchController {


    @Autowired
    private BranchService branchService;

         @GetMapping
        public List<Branch> getAllBranches() throws Exception {
        System.out.println("About to get all  branches.");
        return branchService.getAll();

    }
    }

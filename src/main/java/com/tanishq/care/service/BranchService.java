package com.tanishq.care.service;

import com.tanishq.care.model.Branch;
import com.tanishq.care.model.Student;

import java.util.List;

public interface BranchService
{
    List<Branch> getAll() throws Exception;
}



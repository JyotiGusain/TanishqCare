package com.tanishq.care.service;

import com.tanishq.care.dao.BranchRepository;
import com.tanishq.care.exception.StudentException;
import com.tanishq.care.model.Branch;
import com.tanishq.care.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> getAll() throws Exception {
        try {
            List<Branch> branches = (List<Branch>) branchRepository.findAll();
            System.out.println("Successfully retreived branches total: " + branches.size());
            return branches;
        } catch (Exception e) {
            System.out.println("Error while fetching all branch.");
            throw new Exception("Error while fetching all student.", e);
        }
    }
}

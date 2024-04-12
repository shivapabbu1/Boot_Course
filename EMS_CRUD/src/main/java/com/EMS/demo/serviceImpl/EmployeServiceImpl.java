package com.EMS.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.EMS.demo.Entity.Employee;
import com.EMS.demo.Repo.EmployeeRepo;
import com.EMS.demo.Service.EmployeService;

import lombok.Value;

@Service


public class EmployeServiceImpl implements EmployeService {

    private final EmployeeRepo employeeRepo;

   
    public EmployeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmps() {
        return employeeRepo.findAll();
    }
    
    @Override
	public Employee addNewEmp(Employee employee) {
		return employeeRepo.save(employee);
		
	}

    
    @Override
    public Employee findoutById(int id) {
        Optional<Employee> empOptional = employeeRepo.findById(id);
        return empOptional.orElse(null); 
    }

	@Override
	public Employee updateById(int id,Employee employee) {
	    Optional<Employee> empOptional = employeeRepo.findById(id);
	    if (empOptional.isPresent()) {
	        Employee existingEmployee = empOptional.get();
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setDept(employee.getDept());
	        existingEmployee.setSalary(employee.getSalary());
	        existingEmployee.setGender(employee.getGender());
	        return employeeRepo.save(existingEmployee);
	    } else {
		return null;
	    }
	
      }

	@Override
	public void deleteByid(int id) {
		employeeRepo.deleteById(id);
		
	}

	
}
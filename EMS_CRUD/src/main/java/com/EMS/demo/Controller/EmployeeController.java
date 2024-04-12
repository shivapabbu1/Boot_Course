package com.EMS.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EMS.demo.Entity.Employee;
import com.EMS.demo.Service.EmployeService;
import com.EMS.demo.serviceImpl.EmployeServiceImpl;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	private EmployeServiceImpl a;
	
	public EmployeeController(EmployeServiceImpl a) {
		this.a=a;
	}
	//get all Emps
	
	@GetMapping("Allemps")
	public List<Employee> getListEmps() {
	     return  a.getAllEmps();

	}
	
	//create a new emp
	
	@PostMapping("newEmp")
	public  Employee createNewEmp(@RequestBody Employee employee) {
		return a.addNewEmp(employee);
	}
	
	//get one emp by use reqparams:
	
	@GetMapping("Emp")
	public Employee getemp(@RequestParam("id") int id) {
	    return a.findoutById(id);
	}
	
	//update emp by pathvarable:
	
	@PutMapping("Emp/{id}")
	public Employee update(@PathVariable int id, @RequestBody Employee employee) {
		return a.updateById(id, employee);
	}
	
	//delete one emp by id:
	
	@DeleteMapping("Emp/{id}")
	public String removeEmp(@PathVariable int id) {
		a.deleteByid(id);
	   return "Sucessfully Removed your emp";
	}
	
	
	
	

//    @GetMapping("Allemps")
//    public ResponseEntity<List<Employee>> getListEmps() {
//        List<Employee> employees = a.getAllEmps();
//        return ResponseEntity.ok().body(employees);
//    }
//
//    @PostMapping("newEmp")
//    public ResponseEntity<Employee> createNewEmp(@RequestBody Employee employee) {
//        Employee createdEmployee = a.addNewEmp(employee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
//    }
//
//    @GetMapping("Emp")
//    public ResponseEntity<Employee> getemp(@RequestParam("id") int id) {
//        Employee employee = a.findoutById(id);
//        if (employee != null) {
//            return ResponseEntity.ok().body(employee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("Emp/{id}")
//    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
//        Employee updatedEmployee = a.updateById(id, employee);
//        if (updatedEmployee != null) {
//            return ResponseEntity.ok().body(updatedEmployee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//    
//    @DeleteMapping("Emp/{id}")
//  public String removeEmp(@PathVariable int id) {
//		a.deleteByid(id);
//	   return "Sucessfully Removed your emp";
//	}
   
	
	
}

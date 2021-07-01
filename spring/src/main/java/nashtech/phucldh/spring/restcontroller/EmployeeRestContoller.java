package nashtech.phucldh.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.phucldh.spring.entity.Employee;
import nashtech.phucldh.spring.exception.EmployeeNotFoundException;
import nashtech.phucldh.spring.service.EmployeeDAO;


@RestController
@RequestMapping("/api/employees")
public class EmployeeRestContoller {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping
	public List<Employee> getListCustomer(){
		return employeeDAO.findAll();
	}
	
	@GetMapping("/{customerId}")
	public Employee getCustomerByID(@PathVariable int customerId) {
		Employee customerByID = employeeDAO.getEmployeeById(customerId);
		if (customerByID == null) {
			throw new EmployeeNotFoundException("Customer id: " + customerId + " not found!");
		}
		return customerByID;
	}
	
	@PostMapping
	public Employee addCustomer(@RequestBody Employee newCustomer) {
		newCustomer.setId(0);
		employeeDAO.createEmployee(newCustomer);
		return newCustomer;
	}
	
	@PutMapping
	public Employee updateCustomer(@RequestBody Employee updateCustomer) {
		employeeDAO.updateEmployee(updateCustomer);
		return updateCustomer;
	}
	
	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Employee tempCustomer = employeeDAO.getEmployeeById(customerId);
		if(tempCustomer == null) {
			throw new EmployeeNotFoundException("Customer id: " + customerId + " not found!");
		}
		employeeDAO.deleteEmployee(customerId);
		return "Delete customer id: " + customerId;
	}
}

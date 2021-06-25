package org.nagarro.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.nagarro.employee.model.Employee;
import org.nagarro.employee.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeDaoService")
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@Transactional
	public void saveOrUpdateEmployee(Employee employee) {
		employeeDao.saveOrUpdateEmployee(employee);
	}
	
	
	@Transactional
	public List<Employee> getAllEmployee(){
		return employeeDao.findAllEmployee();
	}
	
	
	@Transactional
	public Employee getEmployee(int employeeCode) {
		return employeeDao.getEmployee(employeeCode);
	}
	
	
	@Transactional
	public void deleteEmployee(int employeeCode) {
		Employee emp = getEmployee(employeeCode);
		if(emp!=null) {
			employeeDao.deleteEmployee(getEmployee(employeeCode));
		}
		
	}

}

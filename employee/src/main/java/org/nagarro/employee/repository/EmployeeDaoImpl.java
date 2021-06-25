package org.nagarro.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.nagarro.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	public void saveOrUpdateEmployee(Employee employee) {
		getSession().saveOrUpdate(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
	}
	
	
	public List<Employee> findAllEmployee(){
		Query<Employee> query = getSession().createQuery("from Employee",Employee.class);
		return query.getResultList();
	}
	
	
	public Employee getEmployee(int employeeCode) {
		return getSession().get(Employee.class, employeeCode);
	}

}

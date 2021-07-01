package nashtech.phucldh.spring.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nashtech.phucldh.spring.entity.Employee;
import nashtech.phucldh.spring.service.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Customer", Employee.class);
		List<Employee> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	public Employee getEmployeeById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theCustomer = currentSession.get(Employee.class, theId);
		return theCustomer;
	}

	@Override
	public void createEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theEmployee);
	}

	@Override
	public void updateEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}
	
	
}

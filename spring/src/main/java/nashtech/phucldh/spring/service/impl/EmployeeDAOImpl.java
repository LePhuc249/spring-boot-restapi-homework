package nashtech.phucldh.spring.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nashtech.phucldh.spring.entity.Employee;
import nashtech.phucldh.spring.service.EmployeeDAO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theCustomer = currentSession.get(Employee.class, theId);
		return theCustomer;
	}

	@Override
	@Transactional
	public void createEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theEmployee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}
	
	
}

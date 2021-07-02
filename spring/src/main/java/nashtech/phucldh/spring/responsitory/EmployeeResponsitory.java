package nashtech.phucldh.spring.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nashtech.phucldh.spring.entity.Employee;

@Repository
public interface EmployeeResponsitory extends JpaRepository<Employee,Integer> {

}

package com.yakidan.spring.spring_boot.dao;

import com.yakidan.spring.spring_boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployee() {
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee ", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//      Session session = entityManager.unwrap(Session.class);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("delete from Employee" +
//                        " where id=:employeeId")
//                .setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee " +
                "where id=:employeeId").setParameter("employeeId", id);
        query.executeUpdate();

    }
}

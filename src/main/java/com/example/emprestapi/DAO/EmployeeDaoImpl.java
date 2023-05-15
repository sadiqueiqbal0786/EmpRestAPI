package com.example.emprestapi.DAO;

import com.example.emprestapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;
     @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee ",Employee.class);
        List<Employee> employees = query.getResultList();
        return employees ;
    }

    @Override
    public Employee findById(int id) {
         Employee employee=entityManager.find(Employee.class,id);
         return employee;
    }

    @Override
    public Employee save(Employee employee) {
         Employee employee1=entityManager.merge(employee);
        return employee1;
    }

    @Override
    public void deleteById(int id) {

         Employee employee = entityManager.find(Employee.class,id);
         entityManager.remove(employee);

    }
}

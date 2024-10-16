package org.dromerof.main;

import org.dromerof.Util.UtilEntity;
import org.dromerof.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        System.out.println("------LISTAR TODOS---------");
        employees.forEach(System.out::println);

        System.out.println("-----BUSCAR UNO-----------");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado" + employee);

        System.out.println("----ELIMINAR-----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar" + employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();

    }
}


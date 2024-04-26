package jpa.controller;

import jpa.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeController {


    public static void showOfficeCodes_AsDepartment(Session sesh) {
        Query query = sesh.getNamedQuery("empDepAlias");
        List<Object[]> officeCodes = query.getResultList();
        for (Object[] code : officeCodes) {
            System.out.println("OfficeCode: " + code[1] + " | Dept Name: " + code[3] + " | Employee Name: " + code[2]);
        }
    }

    public static void findEmployeeById(Session sesh, int id) {
        Query query = sesh.getNamedQuery("get_Emp_name_by_id");
        query.setParameter("id", id);
        List<Object[]> empName = query.getResultList();
        for (Object[] emp : empName) {
            System.out.println("Employee name: " + emp[0] + " | Employee Salary: " + emp[1] + " | Emp Job Title: " + emp[2]);
        }
    }

    public static void findEmployeeByName(Session sesh, String name) {
        try {
            TypedQuery<Employee> query = sesh.createNamedQuery("findEmployeeByName", Employee.class);
            query.setParameter("name", name);
            List<Employee> employees = query.getResultList();
            System.out.printf("%10s%13s%13s%n", "|User Id", "|Full name", "|Salary");
            for (Employee emp : employees) {
                int empId = emp.getId();
                String empName = emp.getName();
                int empSal = emp.getSalary();

                System.out.printf("%10d%13s%13d%n", empId, empName, empSal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createEmployeeTable(Session session) {

        Transaction t = session.beginTransaction();
        try {
            Employee one = new Employee();
            t.commit();
            System.out.println("Successfully created new table...");
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }


    }
}

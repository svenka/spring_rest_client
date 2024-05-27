package com.fyodork.spring.rest;

import com.fyodork.spring.rest.configuration.MyConfig;
import com.fyodork.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication=context.getBean("communication",Communication.class);

        //get all
        List<Employee> allEmployees=communication.getAllEmployees();
        System.out.println(allEmployees);

        //get by id
        Employee empByID=communication.getEmployee(1);
        System.out.println(empByID);

        //add
        Employee emp=new Employee("Sveta","Sokolova","HR",900);

        communication.saveEmployee(emp);

        //update

        Employee emp1=new Employee("Sveta","Sokolova","IT",1000);
        emp1.setId(18);
        communication.saveEmployee(emp);

        //delete
        //communication.deleteEmployee(10);

    }
}

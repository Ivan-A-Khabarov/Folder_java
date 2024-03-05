package DZ3;

import java.util.Comparator;
import java.util.Arrays;


public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.age - employee.age;
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return (int) (e1.getSalary() - e2.getSalary());
    }
}

class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иван", 30, 50000),
                new Employee("Анна", 25, 60000),
                new Employee("Михаил", 35, 45000),
                new Employee("Денис", 21, 43000)
        };

        System.out.println("Сотрудники отсортированные по возрасту:");
        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " " + employee.getAge() + " лет.");
        }
        System.out.println();
        System.out.println("Сотрудники отсортированные по заработной плате:");
        Arrays.sort(employees, new EmployeeSalaryComparator());
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " " + employee.getSalary());
        }
    }
}
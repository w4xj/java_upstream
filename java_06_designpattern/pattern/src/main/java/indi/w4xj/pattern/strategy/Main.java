package indi.w4xj.pattern.strategy;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.strategy
 * @Classname Main
 * @Description 
 * @Date 2022/11/12 15:54
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("zhang3",12,1111.11),
                new Employee("zhang4",22,7111.11),
                new Employee("zhang5",32,3111.11),
                new Employee("zhang6",42,5111.11),
                new Employee("zhang7",52,2111.11)
        );
        //传入不同的策略，具体实现对调用方是透明的，遵守开闭原则
        MyPredicate agePredicate = new AgePredicate();
        MyPredicate salaryPredicate = new SalaryPredicate();
        List<Employee> ageEmployees = filter(employees, agePredicate);
        List<Employee> salaryEmployees = filter(employees, salaryPredicate);
        System.out.println(ageEmployees);
        System.out.println("---------------------------------------");
        System.out.println(salaryEmployees);

        System.out.println("---------------------------------------");
        //当然这里还可以有lambda优化
        ageEmployees = filter(employees, employee -> employee.getAge() > 25);
        salaryEmployees = filter(employees, employee -> employee.getSalary() > 3333);
        System.out.println(ageEmployees);
        System.out.println("---------------------------------------");
        System.out.println(salaryEmployees);
    }
    static  List<Employee> filter(List<Employee> employees, MyPredicate<Employee> predicate){
        List<Employee> returnList = new ArrayList<>();
        for (Employee employee : employees) {
            if(predicate.test(employee)){
                returnList.add(employee);
            }
        }
        return returnList;
    }




}

class AgePredicate implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 25;
    }
}
class SalaryPredicate implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 3333;
    }
}





@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
class Employee{
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name){
        this.name = name;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

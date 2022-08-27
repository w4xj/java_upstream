package indi.w4xj.java8;


import lombok.*;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.java8
 * @Classname Employee
 * @Description
 * @Date 2022/4/12 14:48 下午
 * @Created by IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Employee{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 薪水
     */
    private Double salary;

    public Employee(String name){
        this.name = name;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

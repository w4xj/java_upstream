package indi.w4xj.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.java8
 * @Classname LambdaTest
 * @Description
 * @Date 2022/4/12 15:18 下午
 * @Created by IntelliJ IDEA
 */
public class LambdaTest {
    private List<Employee> employees;
    @Before
    public void before(){
        employees = Arrays.asList(
                new Employee("zhang3",12,1111.11),
                new Employee("zhang4",22,7111.11),
                new Employee("zhang5",32,3111.11),
                new Employee("zhang6",42,5111.11),
                new Employee("zhang7",52,2111.11)
        );
    }

    /**
     * 匿名内部类
     */
    @Test
    public void testAnonymousInnerClass(){

        List<Employee> list = strategyFilter(this.employees, new FilterStrategy<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                if(employee.getAge() > 18){
                    return true;
                }return false;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * lambda代替匿名内部类
     */
    @Test
    public void testLambda(){
        List<Employee> list = strategyFilter(this.employees, e -> e.getAge() > 18);
        list.forEach(System.out::println);
    }

    /**
     * 策略过滤
     * @param list 目标list
     * @param filter 过滤器实现
     * @param <T> 泛型 T
     * @return
     */
    public <T> List<T> strategyFilter(List<T> list, FilterStrategy<T> filter){
        ArrayList<T> result = new ArrayList<>();
        for (T t : list) {
            if (filter.filter(t)){
                result.add(t);
            }
        }
        return result;
    }
}

/**
 * 过滤策略
 * @param <T>
 */
interface FilterStrategy<T>{
    /**
     * 过滤
     * @param t 传入对象
     * @return 是否过滤
     */
    boolean filter(T t);
}


package indi.w4xj.valuetransfer;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.valuetransfer
 * @Classname ValueTransfer
 * @Description
 * @Date 2022/7/18 19:03 下午
 * @Created by IntelliJ IDEA
 */
public class ValueTransfer {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Integer a = 1;
        Integer b = 2;
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        swapBox(a, b);
        swapRef(s1, s2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());



    }
    private static void swapBox(Integer a, Integer b) {
        System.out.println(Thread.currentThread());
        Integer temp;
        temp = a;
        a = b;
        b = temp;
    }
    private static void swapRef(Student s11, Student s22) {
        System.out.println(s11.hashCode());
        System.out.println(s22.hashCode());
//        s11 = new Student("s11");
//        s22 = new Student("s22");
//        System.out.println(Thread.currentThread());
//        Student temp;
//        temp = s11;
//        s11 = s22;
//        s22 = temp;
////        s2.name="s3";
//        System.out.println("--"+s11.name);
//        System.out.println("=="+s22.name);
    }
    static class Student{
        String name;
        public Student(String name) {
            this.name = name;
        }
    }
}

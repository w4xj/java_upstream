package indi.w4xj.jvm.code;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;


/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname CustomClassLoader
 * @Description TODO
 * @Date 2021/5/6 21:19
 * @Created by IntelliJ IDEA
 */
public class CustomClassLoader extends ClassLoader {
    public CustomClassLoader(){
        //指定parent
        super(getSystemClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:/DevTools/myJavaProject/java_upstream/java_02_advanced/target/classes/",
                name.replace(".", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }


    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz1 = customClassLoader.loadClass("indi.w4xj.jvm.code.TargetClass");
            Class<?> clazz2 = customClassLoader.loadClass("indi.w4xj.jvm.code.TargetClass");

            Method method = clazz1.getMethod("method");
            Object object = clazz1.newInstance();
            //invoke method
            method.invoke(object);
            //true
            System.out.println(clazz1 == clazz2);

            //sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(clazz1.getClassLoader());
            //sun.misc.Launcher$ExtClassLoader@61bbe9ba
            System.out.println(clazz1.getClassLoader().getParent());
            //sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(customClassLoader.getClass().getClassLoader());
            //sun.misc.Launcher$ExtClassLoader@61bbe9ba
            System.out.println(customClassLoader.getClass().getClassLoader().getParent());
            //sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(getSystemClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TargetClass {
    public void method() {
        System.out.println("invoke method");
    }
}

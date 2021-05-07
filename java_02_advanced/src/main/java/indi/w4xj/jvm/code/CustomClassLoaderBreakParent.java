package indi.w4xj.jvm.code;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname CustomClassLoaderBreakParent
 * @Description 破坏栓亲委派机制即重写loadClass
 * @Date 2021/5/7 23:19
 * @Created by IntelliJ IDEA
 */
public class CustomClassLoaderBreakParent extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File f = new File("D:/DevTools/myJavaProject/java_upstream/java_02_advanced/target/classes/",
                name.replace(".", "/").concat(".class"));
        try {

            if(!f.exists()){
                super.loadClass(name);
            }
            FileInputStream fis = new FileInputStream(f);

            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

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
            Class<?> clazz1 = customClassLoader.loadClass("indi.w4xj.jvm.code.TargetClass2");
            Class<?> clazz2 = customClassLoader.loadClass("indi.w4xj.jvm.code.TargetClass2");

            Method method = clazz1.getMethod("method");
            Object object = clazz1.newInstance();
            //invoke method
            method.invoke(object);
            System.out.println(clazz1.hashCode());
            System.out.println(clazz2.hashCode());
            //true
            System.out.println(clazz1 == clazz2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TargetClass2 {
    public void method() {
        System.out.println("invoke method");
    }
}


package indi.w4xj.jvm.code;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.image
 * @Classname MetaspaceTest
 * @Description
 * @Date 2021/2/16 13:18
 * @Created by IntelliJ IDEA
 */
public class OOMMetaspaceTest {
    public static void main(String[] args) {
        int number = 0;
        try {
            while (true){
                ++number;
                //用cglib动态创建类信息往Metaspace灌，模拟OOM
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(StaticClass.class);
                enhancer.setUseCache(false);
                //设置回调
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                //生成
                enhancer.create();
            }

        }catch (Throwable e){
            System.out.println("第" + number + "次");
            e.printStackTrace();
        }

    }

    /**
     * 静态内部类，用于模拟生成类往Metaspace灌
     */
    static class StaticClass{}
}

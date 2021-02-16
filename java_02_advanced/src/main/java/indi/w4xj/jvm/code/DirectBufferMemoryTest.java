package indi.w4xj.jvm.code;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname DirectBufferMemoryTest
 * @Description TODO
 * @Date 2021/2/16 12:54
 * @Created by IntelliJ IDEA
 */
public class DirectBufferMemoryTest {
    public static void main(String[] args) {
        System.out.println("maxDirectMemory: " + VM.maxDirectMemory() / (double) (1024 * 1024) + "MB");
        //尝试在直接内存中分配10M空间
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
    }
}

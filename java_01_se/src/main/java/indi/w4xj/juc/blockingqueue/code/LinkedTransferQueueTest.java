package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname LinkedTransferQueueTest
 * @Description
 * @Date 2021/4/5 14:56
 * @Created by IntelliJ IDEA
 */
public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");

        //strs.put("aaa");


		/*
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		*/


    }
}

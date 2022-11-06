package indi.w4xj.jmm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm.code
 * @Classname DisOrder
 * @Description 证明指令重排
 * @Date 2021/5/11 23:33
 * @Created by IntelliJ IDEA
 */
public class DisOrder {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        /*
            分析：假设如果
                a = 1;x = b;
                b = 1;y = a;
            两组没有指令重排，若当x=b执行了，那么a=1必然执行了，若当y=a执行了，那么b=1一定执行了
            所以x y 不可能同时为0.
            如果xy出现同时为0，那么即可证明发生了指令重排
         */
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                    //shortWait(100000);
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}
package indi.w4xj.homework;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.homework
 * @Classname Circleshoot
 * @Description 转圈枪毙
 * @Date 2022/4/22 19:11
 * @Created by IntelliJ IDEA
 */
public class CircleShoot {
    public static void main(String[] args) {
        int[] somebody = new int[73];
        init(somebody);
        shoot(somebody);

    }

    private static void shoot(int[] sb) {
        int survivorCount = sb.length;
        int index = 0;
        int survivor = 0;
        while (survivorCount > 1){
            int shooter = find(sb, index);
            int jinx = find(sb, (shooter+1)% sb.length);
            System.out.println((shooter + 1) + "号 打死了 " + (jinx + 1) + "号");
            sb[jinx] = 0;
            index = (++jinx) % sb.length;
            survivorCount--;
            survivor = shooter;
        }
        System.out.println("幸存者是 " + (survivor + 1) + "号");
    }

    private static int find(int[] sb, int index) {
        while(true){
            if(sb[index] != 1){
                index = (++index) % sb.length;
            }else{
                return index;
            }
        }
    }

    private static void init(int[] sb) {
        for (int i = 0; i < sb.length; i++) {
            sb[i] = 1;
        }
    }


}

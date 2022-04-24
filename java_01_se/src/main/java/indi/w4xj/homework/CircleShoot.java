package indi.w4xj.homework;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.homework
 * @Classname Circleshoot
 * @Description 转圈枪毙
 * 需求：有一把无限子弹的枪，一群人围成一圈，后面一个人把前一个打死，然后把枪给前一个或者的人，问谁最后活着
 * 限定：一个人一次只能开一枪，一个子弹不能穿葫芦（打死多个），也不能打偏，不能卡壳炸膛，必须打到前一个人
 * @Date 2022/4/22 19:11
 * @Created by IntelliJ IDEA
 */
public class CircleShoot {
    public static void main(String[] args) {
        int[] somebody = new int[73];
        //初始化
        init(somebody);
        //开枪
        shoot(somebody);

    }

    /**
     * 开枪
     * @param sb 目标人群
     */
    private static void shoot(int[] sb) {
        //幸存者数量
        int survivorCount = sb.length;
        //当前枪的位置
        int index = 0;
        //当前的幸存者
        int survivor = 0;
        //直到仅幸存一人
        while (survivorCount > 1){
            //找到下一个开枪的人
            int shooter = find(sb, index);
            //找到下一个被打的人
            int jinx = find(sb, (shooter+1)% sb.length);
            System.out.println((shooter + 1) + "号 打死了 " + (jinx + 1) + "号");
            //被射杀修改标记位
            sb[jinx] = 0;
            //一圈完了自动进入下一圈
            index = (++jinx) % sb.length;
            //幸存者-1
            survivorCount--;
            //当前射击者即为幸存者
            survivor = shooter;
        }
        System.out.println("幸存者是 " + (survivor + 1) + "号");
    }

    /**
     * 寻找下一个幸存者
     * @param sb 目标人群
     * @param index 起始位置
     * @return 下一个幸存者的位置
     */
    private static int find(int[] sb, int index) {
        while(true){
            //当前位置的人不存活，则往下（再前一个）找
            if(sb[index] != 1){
                index = (++index) % sb.length;
            }else{
                return index;
            }
        }
    }

    /**
     * 初始化数组，每个值赋为1
     * 0：代表死亡
     * 1：代表活着
     * ps：若把0、1的含义替换，则不需此方法（int默认为0），这里只是为了符合习惯
     * @param sb
     */
    private static void init(int[] sb) {
        for (int i = 0; i < sb.length; i++) {
            sb[i] = 1;
        }
    }


}

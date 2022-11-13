package indi.w4xj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj
 * @Classname TwoSum
 * @Description 
 * @Date 2021/2/28 17:43
 * @Created by IntelliJ IDEA
 *
 *
 * 两数之和:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 *
 *示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

//        Arrays.stream(twoSum1(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSum2(nums, target)).forEach(System.out::println);
    }

    /**
     * 两层循环  O(N²)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 一层循环  O(N)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

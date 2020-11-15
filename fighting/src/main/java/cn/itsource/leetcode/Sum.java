package cn.itsource.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yb
 * @date 2020/11/1 0001 21:28
 * @Description: 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 来源：力扣（LeetCode）
 * @Version:1.0
 */
public class Sum {

    public static int [] sum(int [] nums ,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //数组遍历
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] sum = sum(new int[]{1, 3, 5, 8, 9, 10}, 8);
        System.out.println(Arrays.toString(sum));
    }

}

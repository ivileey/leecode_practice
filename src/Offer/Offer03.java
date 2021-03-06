package Offer;

import java.util.HashSet;

/**
 * @description: 03.数组中重复的数字
 * @author: Yuner
 * @create: 2020-10-10 09:58
 **/
public class Offer03 {
    //使用哈希表
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            }
            hashSet.add(nums[i]);
        }
        return 0;
    }
    //使用临时数组
    public int solution2(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
    //原地交换
    public int solution3(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (i == nums[i])
                continue;
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
            i--;
        }
        return -1;
    }
}

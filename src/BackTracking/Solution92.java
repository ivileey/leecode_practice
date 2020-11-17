package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 子集2
 * @author: Yuner
 * @create: 2020-11-17 13:47
 **/
public class Solution92 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

}

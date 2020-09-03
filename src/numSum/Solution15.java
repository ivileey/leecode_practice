package numSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15.三数之和
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

       Arrays.sort(nums);
       List<List<Integer>> lists = new ArrayList<>();
       for(int k = 0; k < nums.length - 2; k++) {
          if(nums[k] > 0) break;

          if(k > 0 && nums[k] == nums[k - 1]) continue;

          int i = k + 1, j = nums.length - 1;

          while (i < j) {
              int sum = nums[k] + nums[i] + nums[j];

              if(sum < 0) {
                  while (i < j && nums[i] == nums[++i]);
              } else if(sum > 0) {
                  while (i < j && nums[j] == nums[--j]);
              } else {
                  lists.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                  while(i < j && nums[i] == nums[++i]);
                  while(i < j && nums[j] == nums[--j]);
              }
          }
       }
       return lists;
    }
}

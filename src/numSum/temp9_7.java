package numSum;

/**
 * @description: 9月7日复习
 * @author: Yuner
 * @create: 2020-09-07 15:12
 **/
public class temp9_7 {

    public int searchInsert(int[] nums, int target) {

        int mid = 0;
        int left = 0,right = nums.length - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;
        int i = 0;

        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j])
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i +1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int median1 = 0,median2 = 0;
        while(left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums_1l = (i==0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_1r = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_2l = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_2r = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_1l <= nums_2r) {
                median1 = Math.max(nums_1l,nums_2l);
                median2 = Math.min(nums_1r,nums_2r);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}

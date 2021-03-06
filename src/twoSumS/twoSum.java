package twoSumS;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] res = new Solution().twoSum(nums,9);

        System.out.println("结束");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                // 如果和大于目标数字，那么j往左走，缩小一些
                j --;
            }else if (sum < target) {
                // 如果和小于目标数字，那么i往右走，放大一些
                i ++;
            }else {
                // 相等则返回i,j
                return new int[] {nums[i],nums[j]};
            }
        }

        // 否则返回[0]
        return new int[0];
    }
}
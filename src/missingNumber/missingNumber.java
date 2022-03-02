package missingNumber;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class missingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        int res = new Solution().missingNumber(nums);
        System.out.println(res);
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        // 定义左右边界
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            // 先计算中点
            int m = (i + j) / 2;

            if (nums[m] == m ) {
                // 如果这时候nums[中点]的数等于当前中点的值，代表之前的都是按照顺序递增，没有问题，所以一定在中点的右边
                i = m + 1;
            }else {
                // 否则就是在左边
                j = m - 1;
            }

        }

        return i;
    }
}
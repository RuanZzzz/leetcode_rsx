package search;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class search {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int res = new Solution().search(nums,8);

        System.out.println(res);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // 先搜索右边界right
        while (i <= j) {
            int m = (j + i) / 2;
            // 这里是“小于等于”，目的是为了确定右边界，就是说当mid等于target时，因为不确定后面还有没有target，所以同样需要左边收缩范围
            if (nums[m] <= target) {
                // 小的话，i 就往右半区移动，缩小范围
                i = m + 1;
            }else {
                // 大的话， j 就往左移动，缩小范围
                j = m - 1;
            }
        }

        int right = i;

        // 如果没有搜索到目标则直接返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }

        // 搜索左边界
        i = 0; j = nums.length - 1;
        while (i <= j) {
            int m = (j + i) / 2;
            if (nums[m] >= target) {
                // 大的话， j 就往左移动，缩小范围
                j = m - 1;
            }else {
                // 小的话，i 就往右半区移动，缩小范围
                i = m + 1;
            }
        }

        int left = j;

        return right - left - 1;
    }
}
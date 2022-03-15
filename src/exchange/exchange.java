package exchange;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new Solution().exchange(nums);

        System.out.println("结束");
    }
}


class Solution {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int tmp;

        while (i < j) {
            // 寻找首个偶数
            while (i < j && (nums[i] % 2) != 0) {
                i ++;
            }

            // 寻找首个奇数
            while (i < j && (nums[j] % 2) == 0) {
                j --;
            }

            // 遇到奇数偶数后，交互nums[i] 和 nums[j] 的值
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return nums;
    }
}
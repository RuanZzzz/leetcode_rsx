package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new Solution().threeSum(nums);

        System.out.println("结束");
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先从小到大排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 当当前节点大于0时，后续就更大，永远不能加等于0
            if (nums[i] > 0) {
                break;
            }

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    // 如果左边有重复的
                    while (L < R && nums[L] == nums[L + 1]) {
                        L ++;
                    }
                    // 如果右边有重复的
                    while (L < R && nums[R] == nums[R - 1]) {
                        R --;
                    }
                    // 如果没有重复的
                    L++;
                    R--;
                }
                if (sum < 0) {
                    L ++;
                }
                if (sum > 0) {
                    R --;
                }
            }

        }

        return res;
    }
}
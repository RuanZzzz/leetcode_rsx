package minArray;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 */
public class minArray {

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        int res = new Solution().minArray(numbers);

        System.out.println(res);
    }
}


class Solution {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        int m = 0;

        while (i < j) {
            // 计算中心点
            m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                // 如果中心点大于最右边，那么最小值（旋转点）可能在右半部分
                i = m + 1;
            }else if (numbers[m] < numbers[j]) {
                // 如果中心点小于最右边，那边旋转点可能在左边
                j = m;
            }else {
                // 如果numbers[m] == numbers[j]，可以缩小最右减小范围
                j --;
            }
        }

        return numbers[i];
    }
}
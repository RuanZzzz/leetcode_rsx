package findNumberIn2DArray;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        boolean res = new Solution().findNumberIn2DArray(matrix,8);
        System.out.println(res);
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从左下角开始找
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length ) {
            if (matrix[i][j] > target) {
                // 消除行，因为右边递增不会有target
                i --;
            }else if (matrix[i][j] < target) {
                // 消除列，因为target比它大，会在右边递增那块
                j ++;
            }else {
                // 找到了
                return true;
            }
        }
        return false;
    }
}
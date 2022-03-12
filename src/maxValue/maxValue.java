package maxValue;

/**
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class maxValue {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        int res = new Solution().maxValue(grid);

        System.out.println(res);
    }
}

class Solution {
    public int maxValue(int[][] grid) {
        // 行
        int m = grid.length;
        // 列
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }else if (i == 0) {
                    // 第一行的情况，只能往右走
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if (j == 0) {
                    // 第一列的情况，只能往下走
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else {
                    grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j],grid[i][j - 1]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
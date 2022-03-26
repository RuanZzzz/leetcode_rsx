package reverse;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 *
 */
public class reverse {
    public static void main(String[] args) {
        int res = new Solution().reverse(123);
        System.out.println(res);
    }
}

class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 判断每次res是否超过最大值
            if (res > 214748364 ) {
                return 0;
            }
            // 判断每次res是否小于最小值
            if (res < -214748364) {
                return 0;
            }

            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;
    }
}

package sumNums;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 */
public class sumNums {
    public static void main(String[] args) {
        int res = new Solution().sumNums(3);
        System.out.println(res);
    }
}


class Solution {
    public int sumNums(int n) {
        boolean res = n > 0 && (n += sumNums(n - 1)) > 0;

        return n;
    }
}
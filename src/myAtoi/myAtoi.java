package myAtoi;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 */
public class myAtoi {
    public static void main(String[] args) {
        int res = new Solution().myAtoi(" -42");
        System.out.println(res);
    }
}

class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        // 转换成字符串数组
        char[] charArr = s.toCharArray();
        // 定义索引
        int index = 0;

        // 1、去除前导空格
        while (index < len && charArr[index] == ' ') {
            // 更新索引
            index++;
        }

        // 2、如果遍历完成，则直接返回
        if (index == len) {
            return 0;
        }

        // 3、仅判断第一个字符的正负
        int sign = 1;
        char firstChar = charArr[index];
        if (firstChar == '+') {
            index++;
        }else if (firstChar == '-') {
            sign = -1;
            index++;
        }

        // 4、开始转换
        int res = 0;
        while (index < len) {
            // 先判断首个字符合不合法
            char curChar = charArr[index];
            if (curChar > '9' || curChar < '0') {
                break;
            }

            // 判断越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (curChar - '0');
            index++;
        }

        return res;
    }
}
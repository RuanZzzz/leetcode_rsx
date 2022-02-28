package reverseLeftWords;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 */
public class reverseLeftWords {

    public static void main(String[] args) {
        String res = new Solution().reverseLeftWords("abcdefg",2);

        System.out.println(res);
    }

}


class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();

        // 先拼接从n开始，字符串s的后几位
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }

        // 再拼接n开始的前几个
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }
}



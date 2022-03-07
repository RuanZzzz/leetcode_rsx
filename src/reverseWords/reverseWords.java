package reverseWords;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class reverseWords {
    public static void main(String[] args) {
        String res = new Solution().reverseWords("the sky is blue");
        System.out.println(res);
    }
}


class Solution {
    public String reverseWords(String s) {
        // 去除头尾的空格
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int j = s.length() - 1;
        int i = j;

        while (i >= 0) {
            // 先跳过所有的字符，找到首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i --;
            }
            // 找到之后进行字符拼接
            res.append(s.substring(i + 1,j + 1) + ' ');
            // 再跳过所有的空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i --;
            }
            // 然后将j放到i一起的位置，进入下一轮搜索
            j = i;
        }

        return res.toString().trim();
    }
}
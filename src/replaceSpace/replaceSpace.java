package replaceSpace;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class replaceSpace {

    public static void main(String[] args) {
        String res = new Solution().replaceSpace("We are happy.");
        System.out.println(res);
    }

}

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            }else {
                res.append(c);
            }

        }

        return res.toString();
    }
}

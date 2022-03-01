package firstUniqChar;

import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 */
public class firstUniqChar {
    public static void main(String[] args) {
        char res = new Solution().firstUniqChar("abaccdeff");
        System.out.println(res);
    }
}

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> strMap = new HashMap<>();
        for (Character str : s.toCharArray()) {
            // 如果不存在（第一次出现），则存放的是TRUE；如果存在（第二次及以上出现），则存放FALSE
            strMap.put(str,!strMap.containsKey(str));
        }

        // 开始查看是否有存在的
        for (Character str : s.toCharArray()) {
            if (strMap.get(str)) {
                return str;
            }
        }

        return ' ';
    }
}
package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new Solution().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic = new HashMap<>();
        int res = 0,tmo = 0;

        for (int j = 0; j < s.length() ; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
        }

        return res;
    }
}
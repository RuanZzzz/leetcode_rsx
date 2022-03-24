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
        // 存放不重复的字符和它的位置
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        // 无重复的最大长度
        int ans = 0;

        for (int start = 0,end = 0; end < n; end++) {
            char c = s.charAt(end);
            // 如果遇到重复的字符了
            if (map.containsKey(c)) {
                // 更新start的位置
                start = Math.max(map.get(c),start);
            }
            // 如果没遇到重复的字符
            // 更新ans的最大长度
            ans = Math.max(ans,end - start + 1);
            // 更新字符串和位置，end + 1就表示它下一个不重复
            map.put(s.charAt(end),end + 1);
        }

        return ans;
    }
}
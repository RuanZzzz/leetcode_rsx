package isUnique;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 */
public class isUnique {

    public static void main(String[] args) {
        boolean res = new Solution().isUnique("leetcode");
        System.out.println(res);
    }

}


class Solution {
    public boolean isUnique(String astr) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < astr.length(); i++) {
            if (map.containsKey(astr.charAt(i))) {
                return false;
            }
            map.put(astr.charAt(i),1);
        }

        return true;
    }
}


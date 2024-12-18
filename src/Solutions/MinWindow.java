package Solutions;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    class Solution {
    /*
    用两个map统计
    tMap： 统计t中不同字符出现的个数
    windowMap: 统计当前window中t内字符出现的个数

    required = size（set （tMap））
    formed = windowMap中满足条件的字符个数

    每次只需根据r，l位置的字符判断是否满足条件 而无需遍历整个map
    */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 统计 t 中每个字符的出现次数
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        Map<Character, Integer> windowCount = new HashMap<>();
        int l = 0, r = 0;
        int required = tCount.size(); // t 中不同字符的数量
        int formed = 0; // 当前窗口满足条件的不同字符数量
        int minLen = Integer.MAX_VALUE;
        int start = -1;

        while (r < s.length()) {
            // 扩展窗口
            char c = s.charAt(r);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // 如果窗口中该字符数量已满足 t 中该字符的数量，增加 formed
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // 尝试收缩窗口
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // 更新最小长度子串
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                // 移动左边界
                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            // 移动右边界
            r++;
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
}

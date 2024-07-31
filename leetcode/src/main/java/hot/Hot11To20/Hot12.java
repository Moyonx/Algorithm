package hot.Hot11To20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moyon
 * @description 最小覆盖子串
 * @date 2024/07/30
 */
public class Hot12 {

    public String minWindow(String s, String t) {
        // 定义两个map，分别存放窗口中的字符和目标字符串中的字符
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // 初始化need
        for(char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 定义左右指针和最小覆盖子串的起始位置和长度，以及窗口中满足条件的字符个数
        int left = 0, right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int count = 0;

        // 循环
        while(right < s.length()) {
            // 记录变化位置的数据并更新窗口
            char c = s.charAt(right);
            right++;
            // 如果目标字符串中包含该字符，则更新窗口map中的数据和count
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中的字符c个数与目标字符串中的c个数相等，则count++
                if(window.get(c).equals(need.get(c))) {
                    count++;
                }
            }
            // 当count等于目标字符串的长度时，说明窗口中的字符已经满足条件，进行窗口压缩
            while(count == need.size()) {
                // 更新最小覆盖子串的起始位置和长度
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 记录变化位置的数据并更新窗口
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    // 如果窗口中的字符d个数与目标字符串中的d个数相等，则count--
                    if(window.get(d).equals(need.get(d))) {
                        count--;
                    }
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public static void main(String[] args) {
        Hot12 t12 = new Hot12();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(t12.minWindow(s, t));
    }
}

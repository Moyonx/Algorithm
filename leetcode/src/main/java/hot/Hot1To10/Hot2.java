package hot.Hot1To10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Moyon
 * @description 字母异位词分组
 * @date 2024/07/03
 */
public class Hot2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            // 对每个字符串中出现的字母次数进行排序
            int[] counts = new int[26];
            for(int i=0;i<str.length();i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将字符和计数结果统计作为key
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++) {
                if(counts[i] != 0) {
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            // 生成value，如果map中有key对应的value，就先取出来再加上，没有就生成一个空的
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            // 存入map
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                s -> Arrays.toString(s.codePoints().sorted().toArray())
        )).values());
    }

    public static void main(String[] args) {
        Hot2 hot2 = new Hot2();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = hot2.groupAnagrams2(strs);
        System.out.println(lists);
    }
}

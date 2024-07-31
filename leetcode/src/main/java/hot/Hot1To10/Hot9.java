package hot.Hot1To10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Moyon
 * @description 找到字符串中所有字母异位词
 * @date 2024/07/19
 */
public class Hot9 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int n1 = s.length();
        int n2 = p.length();

        if(s == null || p == null || n1 < n2) {
            return list;
        }

        int[] countS = new int[26];
        int[] countP = new int[26];
        for(int i=0;i<p.length();i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(countS, countP)) {
            list.add(0);
        }

        int left = 0;
        int right = left + n2 - 1;

        while(true) {
            countS[s.charAt(left) - 'a']--;
            left++;
            right++;
            if(right>= n1) {
                break;
            }
            countS[s.charAt(right) - 'a']++;
            if(Arrays.equals(countS, countP)) {
                list.add(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Hot9 hot9 = new Hot9();
        System.out.println(hot9.findAnagrams("cbaebabacd", "abc"));
    }
}

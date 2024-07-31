package hot.Hot1To10;

/**
 * @author Moyon
 * @description 无重复字符的最长字串
 * @date 2024/07/18
 */
public class Hot8 {

    public int lengthOfLongestSubstring(String s) {

        int val = 0;
        int n = s.length();

        int i = 0;
        int j = 0;
        while(i < n && j < n) {
            if(s.substring(i, j).contains(s.substring(j, j+1))) {
                i++;
            }else {
                j++;
                val = Math.max(val, j - i);
            }
        }
        return val;
    }
}

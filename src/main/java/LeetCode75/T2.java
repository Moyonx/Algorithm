package LeetCode75;

/*
对于字符串s和t，只有在s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定“t 能除尽 s”。

给定两个字符串str1和str2。返回 最长字符x，要求满足x 能除尽 str1 且 x 能除尽 str2 。

示例 1：

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""

 */
public class T2 {
    public static String gcdOfStrings(String str1, String str2) {
        String value = "";

        int len1 = str1.length();
        int len2 = str2.length();

        for(int i=Math.min(len1,len2);i>=1;--i){
            if(len1%i==0 &&len2%i==0){
                String temp = str1.substring(0,i);
                if(checkIs(str1,temp)&&checkIs(str2,temp)){
                    return temp;
                }
            }
       }

        return "";
    }

    public static boolean checkIs(String s1,String s2){
        int num = s1.length() / s2.length();
        StringBuilder s = new StringBuilder();
        for(int i=0;i<num;i++){
            s.append(s2);
        }
        return s.toString().equals(s1);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
    }
}

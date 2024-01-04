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
    //法1
    public static String gcdOfStrings(String str1, String str2) {
        String value = "";

        int len1 = str1.length();
        int len2 = str2.length();

        //找到最大公约数并判断截取后的字符串是否符合题意
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

    //法二
    public static int gcd(int a,int b){
        int remainder = a % b;
        while (remainder!=0){
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static String gcdOfStrings2(String s1,String s2){
        int len1 = s1.length(), len2 = s2.length();
        String s = s1.substring(0,gcd(len1,len2));
        if(checkIs(s1,s)&&checkIs(s2,s)){
            return s;
        }
        return "";
    }

    //法三~比较nb，非常简洁
    public static String gcdOfStrings3(String s1,String s2){
        //如果两个字符串按不同的前后关系相加不等，则肯定结果为空
        if(!(s1+s2).equals(s2+s1)){
            return "";
        }
        //如果是存在的，那么直接截取s1的s1和s2最大公约数的位数（用辗转相除法）
        return s1.substring(0,gcd2(s1.length(),s2.length()));
    }

    public static int gcd2(int l1,int l2){
        return l2==0? l1 : gcd2(l2,l1 % l2);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings3("ABABAB","ABAB"));
    }
}

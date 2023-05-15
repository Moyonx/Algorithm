package topics;

public class P278 {
    //第一个错误的版本
    public static int firstBadVersion(int n){
        int left = 1;
        int right = n;
        while(left<right){
            //防止计算时溢出
            int place = left + (right - left) / 2;
            if(isBadVersion(place)==false){
                left = place + 1;
            }else{
                right = place;
            }
        }
        return right;
    }

    public static boolean isBadVersion(int version){
        if(version==4){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        firstBadVersion(7);
    }
}

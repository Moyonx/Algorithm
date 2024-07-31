package LeetCode75;

public class T4 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int m = flowerbed.length;;
        for (int i = 0; i < m; i++) {
            if ((i==0||flowerbed[i-1]==0)&&flowerbed[i]==0&&(i==m-1||flowerbed[i+1]==0)){
                flowerbed[i]=1;
                cnt++;
            }
        }
        return cnt >= n;
    }
}

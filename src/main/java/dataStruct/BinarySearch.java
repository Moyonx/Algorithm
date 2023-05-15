package dataStruct;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 48;
        int idx = binarySearch(array,target);
        System.out.println(idx);
    }
    public static int binarySearch(int[] a,int t){
        int l = 0, r = a.length - 1, m;
        while(l<=r){
            m = l + (r - l) / 2;
            if(a[m] == t){
                return m;
            }else if(a[m] < t){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
}

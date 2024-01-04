package dataStruct;

import java.util.Arrays;

public class Sort {
    public static int[] insertSort(int[] a,int n){
        int i,j;
        for(i=2;i<=n;i++){
            if(a[i]<a[i-1]){
                a[0]=a[i];
                for(j=i-1;a[j]>a[0];--j){
                    a[j+1] = a[j];
                }
                a[j+1] = a[0];
            }
        }
        a[0] = 0;
        return a;
    }

    public static void main(String[] args) {
        int[] a = {0,49,38,65,97,76,13,27,49};
        System.out.println(Arrays.toString(insertSort(a, 8)));
    }
}

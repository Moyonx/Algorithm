package topics;

public class P977 {
    //有序数组的平方
    public int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] val = new int[n];
        for(int i=0,j=n-1,pos=n-1;i<=j;){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                val[pos] = nums[i]*nums[i];
                i++;
            }else{
                val[pos] = nums[j]*nums[j];
                j--;
            }
            pos--;
        }
        return val;
    }
}

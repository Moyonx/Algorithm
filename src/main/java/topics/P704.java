package topics;

public class P704 {
    //二分查找
    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int place = (left + right) / 2;
            if(nums[place]==target){
                return place;
            }else if(nums[place]<target){
                left = place + 1;
            }else{
                right = place - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int place = search(new int[]{-1,0,3,5,9,12},2);
        System.out.println(place);
    }
}

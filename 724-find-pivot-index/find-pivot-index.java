class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int RightSum=0;
        int LeftSum=0;
        for(int i=0;i<nums.length;i++){
            RightSum=sum-LeftSum-nums[i];
            if(LeftSum==RightSum){
                return i;
            }
            LeftSum+=nums[i];
        }
        return -1;
    }
}
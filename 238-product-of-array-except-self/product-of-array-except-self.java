class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];
        sol[0] = 1;
        int prod = 1;
        for(int i =1; i < nums.length; i++){
            prod = prod * nums[i-1];
            sol[i] = prod; 
        }
        prod = 1;
        for(int i = nums.length-2; i >=0; i--){
            prod = prod * nums[i+1];
            sol[i] = sol[i] * prod;
        }
        return sol;
    }
}
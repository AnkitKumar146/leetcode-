class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        int sumdigit=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            sum+=n;
            while(n>0){
            sumdigit+=n%10;
            n=n/10;
            }
        }
        return Math.abs(sum-sumdigit);
    }
    
}
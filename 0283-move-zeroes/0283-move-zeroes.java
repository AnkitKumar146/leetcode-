class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length, i=0, j=0;
       while(j<n){
        if(nums[j]!=0){
            nums[i]=nums[j];
            i++;
        }
        j++;
       }
       while(i<j){
        nums[i]=0;
        i++;
       }
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <3){
            return nums[nums.length -1];
        }
        else{
            int c= 0;
            for(int  i=nums.length-1 ;i>0; i--){
                if(nums[i-1]<nums[i]){
                    c+=1;
                    if(c==2){
                        return nums[i-1];
                    }
                }
            }
            return nums[nums.length-1];
        }
    }
}
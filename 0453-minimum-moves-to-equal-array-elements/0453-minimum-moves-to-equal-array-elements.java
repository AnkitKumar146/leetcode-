class Solution {
    public int minMoves(int[] nums) {
        int min= nums[0];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        for(int j=0;j<nums.length;j++){
        ans+=nums[j]-min;
        }
    return ans;
}
}
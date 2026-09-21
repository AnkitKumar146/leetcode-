class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[][] dp = new long[nums.length +1][k];

        for(int i =0;i<nums.length;i++){
            int r =nums[i]% k;

            dp[i+1][r]++;

            for(int j =0;j< k;j++){
                int next = (j*r)%k;
                dp[i +1][next] +=dp[i][j];
            }
            for(int j =0; j< k; j++){   
                ans[j] +=dp[i +1][j];
        }
        }
        return ans;
    }
}
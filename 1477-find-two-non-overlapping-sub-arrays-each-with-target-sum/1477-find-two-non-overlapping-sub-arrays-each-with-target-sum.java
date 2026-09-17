class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int left =0, sum =0;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int right =0;right <n;right++) {
            sum +=arr[right];

            while (sum>target){  
                sum -=arr[left++];
            }
            if (sum ==target) {
                int len = right -left+1;

                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE)
                    ans = Math.min(ans, len + dp[left - 1]);
                min = Math.min(min, len);
            }
            dp[right] = min;
        }
            if (ans == Integer.MAX_VALUE){  
        return -1;
            }else{  
        return ans;

    }
    }
}
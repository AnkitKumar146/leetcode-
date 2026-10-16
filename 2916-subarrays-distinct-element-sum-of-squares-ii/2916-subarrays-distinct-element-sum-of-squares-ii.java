class Solution {
    public int sumCounts(int[] nums) {
      int n = nums.length;
        long mod = 1000000007;

        long[] count = new long[n + 1];
        long[] sum = new long[n + 1];
        Map<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int p = last.getOrDefault(nums[r], -1);
            long c = 0;
            long s = 0;

            for (int i = n - p - 1; i > 0; i -= i & -i) {
                c += count[i];
                s += sum[i];
            }

            long gain = (long) (r - p) * (r - p) - 2 * (s - p * c);
            ans = (ans + (n - r) * gain) % mod;

            for (int i = n - p; i <= n; i += i & -i) {
                count[i]++;
                sum[i] += p;
            }

            last.put(nums[r], r);
        }

        return (int) ans;
    }
}
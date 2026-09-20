class Solution {
    public long maxValue(int[] nums) {
    /*    long base = 0;

        for(int i =0; i <nums.length;i++){
            if(i %2 ==0) base+=nums[i];
            else base -= nums[i];
        }

        long odd =Long.MAX_VALUE;
        long even =Long.MAX_VALUE;
        long best =Long.MAX_VALUE;
        for(int i =0; i<nums.length; i++){
            long x = (i %2 == 0) ? nums[i] : -nums[i];

            long newOdd =x;
            if(odd !=Long.MAX_VALUE)
                newOdd =Math.min(newOdd, odd + x);
            long newEven =Long.MAX_VALUE;
            if(odd !=Long.MAX_VALUE)
                newEven =odd + x;

            odd =newOdd;
            even =newEven;
            best =Math.min(best, even);
        }
        if(best ==Long.MAX_VALUE)
            return base;
        return base -2 *best;  */
        long sum =0;
        long gain =0;
        long even =Long.MIN_VALUE;
        long odd = Long.MIN_VALUE;

        for(int i =0; i <nums.length;i++){
            long x = (i % 2 ==0) ?nums[i] : -nums[i];
            long temp = 2 * sum + x;

            even =Math.max(even,temp +nums[i]);
            odd =Math.max(odd,temp -nums[i]);

            sum += x;

            long best =(i %2 ==0) ? even : odd;
            gain =Math.max(gain,best -2 *sum);
        }
        return sum +gain;
    }
}
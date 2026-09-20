class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        /* int[][] arr =intervals;

        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        long ans =0;
        int j =0;
        for(int i =0;i<intervals.length;i++){
            while(j <i && intervals[j][1]<intervals[i][0])
                j++;
            ans +=i -j;
        }
        return ans; */
        int n =intervals.length;
        
        int[] start =new int[n];
        int[] end= new int[n];
        for(int i =0;i <n;i++){
            start[i] =intervals[i][0];
            end[i] =intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        long ans =0;
        int j =0;
        for(int i =0;i< n;i++){
            while(j <i && end[j] <start[i])
                j++;
            ans += i - j;
        }
        return ans;
    }
}
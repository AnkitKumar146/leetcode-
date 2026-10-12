class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int n= nums.size();
        int mod= 1000000007;
        int [] bit=new int[31];
        for(int i=0;i <n;i++){
            for(int j= 0;j<31;j++){
                if((nums.get (i) & (1<<j)) !=0){
                    bit[j]++;
                }
            }
        }
        long ans= 0;
        for(int i=0;i<k;i++){
            long num= 0;
            for(int j=0;j< 31;j++){
                if(bit[j]>0){
                    num|=(1L<<j);
                    bit[j]--;
                }
            }
            ans =(ans + num * num)%mod;
        }
        return (int)ans;
    }
}
   
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] arr= new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->{
            int x=digSum(a[0]);
            int y=digSum(b[0]);
            if(x==y){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(x,y);
        });
        int[] pos=new int[n];
        for(int i=0;i<n;i++){
            pos[arr[i][1]]=i;
        }
        boolean[] visited=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++){
            int j=i;
            int count=0;
            while(!visited[j]){
                visited[j]=true;
                j=pos[j];
                count++;
            }
            if(count>1){
                swaps+=count-1;
            }
        }
        return swaps;
    }
    private int digSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
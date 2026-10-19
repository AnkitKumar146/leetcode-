class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0,count=0;
        for(int x:nums){
            if(x<target){  
            less++;
            }
            if(x==target){  
            count++;
        }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(less + i);
        }
        return list;    
        }
}
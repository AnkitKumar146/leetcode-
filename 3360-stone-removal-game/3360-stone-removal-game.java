class Solution {
    public boolean canAliceWin(int n) {
        int i=10;
        while(n!=0 && n>=i){
            n=n-i;
            i--;
        }
        if(i%2==0){ 
        return false;
        }
        return true; 
    }
}
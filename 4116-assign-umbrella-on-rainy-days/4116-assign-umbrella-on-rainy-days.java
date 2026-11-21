class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] ans = new String[n];
        int a = 0, b = 0;
        for(int i = 0; i<n ; i++){
            if(rain[i] == 0){
                ans[i] = "None";
            } else if (i + 1 < n && rain[i + 1] == 1 && a <= b){
                ans[i] = "Alice";
                a++;
            } else {
                ans[i] = "Bob";
                b++;
            }
        }
        return ans;
        
    }
    }

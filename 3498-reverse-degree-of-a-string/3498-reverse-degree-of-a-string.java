class Solution {
    public int reverseDegree(String s) {
         int sum =0, pos =1;
        for(char c : s.toCharArray())
            sum += ('z' - c +1)*pos++;
        return sum;
    }
}
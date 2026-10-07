class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int left=0, right=0;
        for(char c : s.toCharArray()){
            if(c =='(')
                left++;
            else if(c ==')'){
                if(left>0)
                    left--;
                else
                    right++;
            }
        }

        solve(s, 0, left, right, ans);
        return ans;
    }

    void solve(String s, int start, int left, int right, List<String> ans) {
        if(left == 0 && right == 0){
            if(valid(s))
                ans.add(s);
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(i > start && s.charAt(i) == s.charAt(i - 1))
                continue;

            if(left > 0 && s.charAt(i) == '(')
                solve(s.substring(0, i) + s.substring(i + 1),
                      i, left - 1, right, ans);

            if(right > 0 && s.charAt(i) == ')')
                solve(s.substring(0, i) + s.substring(i + 1),
                      i, left, right - 1, ans);
        }
    }

    boolean valid(String s) {
        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '(')
                count++;
            else if(c == ')'){
                count--;
                if(count < 0)
                    return false;
            }
        }

        return count == 0;
    }
}
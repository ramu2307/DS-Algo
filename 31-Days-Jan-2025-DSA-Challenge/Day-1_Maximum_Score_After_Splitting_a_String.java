Time Complexity  : O(N)
Space Complexity : O(1)
class Solution {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        int zero = 0;
        int one = 0;
        if(s.charAt(0) == '0') {
            zero = 1;
        }
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                one++;
            }
        }
        max = Math.max(max, zero + one);
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0') {
                zero++;
            }
            else{
                one--;
            }
            max = Math.max(max, zero + one);
        }
        return max;
    }
} 

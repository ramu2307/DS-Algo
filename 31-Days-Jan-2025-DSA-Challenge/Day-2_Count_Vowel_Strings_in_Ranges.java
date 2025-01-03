Brute Force Solution :
Time Complexity  : O(n * q)
Space Complexity : O(1)

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String regex = "aeiou";
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (regex.indexOf(words[j].charAt(0)) != -1 && regex.indexOf(words[j].charAt(words[j].length() - 1)) != -1) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}


Optimal Solution : [ Prefix-Sum ]
Time Complexity : O(n) + O(q)
Space Complexity : O(n) + O(q)

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefix[] = new int[words.length];
        int cnt = 0;
        String regex = "aeiou";
        for(int i = 0; i < words.length; i++) {
            if(regex.indexOf(words[i].charAt(0)) != -1 && regex.indexOf(words[i].charAt(words[i].length() - 1)) != -1) {
                cnt++;
            }
            prefix[i] = cnt;
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = (queries[i][0] == 0) ? (prefix[queries[i][1]]) : (prefix[queries[i][1]] - prefix[queries[i][0] - 1]);
        }
        return ans;
    }
}
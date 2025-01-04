Brute Force Solution :
Time Complexity : O(N * N * N)
	Outer Loop - O(N)
	Middle Loop - O(N)
	Inner Loop - O(N)
Space Complexity : O(N * N) + O(1)
	HashSet : In Worst Case, stores all unique Palindrome Strings of length-3. There can be atmost O(N * N) unique Strings.
	StringBuilder : Constant space - O(1)
	

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
    
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(i)).append(s.charAt(j)).append(s.charAt(k));
                    if(s.charAt(i) == s.charAt(k)) {  // 3-length String. So, middle can be any character but first and third character should be same for palindorme
                        set.add(sb.toString());
                    }
                }
            }
        }
        return set.size();
    }
}

Optimal Solution :

Time Complexity : O(26) + O(26 * O(N + N)) - OverAll : O(N)

	First Loop (Unique Set) : worst case - O(26)

	Outer Loop : Iterates through unique Set. So worst case - O(26)
	Finding first and last Occurences : Iterates through String of length-N. So, worst case - O(N)
	Inner Loop : Iterates from first to last index. Worst Case - O(N)

Space Complexity : O(26) + O(N) - OverAll - O(N)

	HashSet Unique : Stores Unique Characters. Worst Case - O(26)
	HashSet set : Stores unique Characters found b/w first and last index. Worst Case - O(N)

	
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> unique = new HashSet<>();
        for(char ch : s.toCharArray()) {
            unique.add(ch);
        }

        int ans = 0;

        for(char ch : unique) {
            int first = -1;
            int last = -1;

            for(int i = 0; i < n; i++) {
                if(ch == s.charAt(i)) {
                    if(first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }

            HashSet<Character> set = new HashSet<>();
            for(int j = first + 1; j < last; j++) {
                set.add(s.charAt(j));
            }

            ans += set.size();
        }
    
        return ans;
    }
}
 

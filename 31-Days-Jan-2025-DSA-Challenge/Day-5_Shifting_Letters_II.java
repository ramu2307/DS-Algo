Brute Force Solution :

Time Complexity : O(m * n) + O(n)

	Outer Loop runs [m] times, Where m - length of shifts
	Inner Loop runs from left to right index. So worst case, it runs upto [n]
	Overall complexity - O(m * n)
	
	2nd Loop runs [n] times - O(n)

Space Complexity : O(n) + O(n)

	diff Array - O(n)
	StringBuilder : It stores resulting String of length [n] - O(n)

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];
        for(int i = 0; i < shifts.length; i++) {
            int left = shifts[i][0];
            int right = shifts[i][1];
            int direction = shifts[i][2];
            for(int j = left;  j <= right; j++) {
                if(direction == 1) {
                    diff[j]++;
                }
                else {
                    diff[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int nextChar = ((s.charAt(i) - 'a') + diff[i] ) % 26;
            if(nextChar < 0) {
                nextChar += 26;
            }

            sb.append((char)('a' + nextChar));
        }
        return sb.toString();
    }
}


Optimal Solution : [ Difference Array Technique (or) Lazy Propagation for Range Updates ] + [ Prefix-Sum ]

Time Complexity : O(m + n)
	
	1st Loop runs for [m] shifts - O(m)
	2nd Loop iterates over length of String [n] - O(n)

Space Complexity : O(n + n)

	diff Array - O(n)
	StringBuilder : It stores resulting String of length [n] - O(n)

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for(int i = 0; i < shifts.length; i++) {
            int left = shifts[i][0];
            int right = shifts[i][1];
            int direction = shifts[i][2];
            if(direction == 1) {
                diff[left]++;
                diff[right + 1]--;
            }
            else {
                diff[left]--;
                diff[right + 1]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += diff[i];
            int nextChar = ((s.charAt(i) - 'a') + count ) % 26;
            if(nextChar < 0) {
                nextChar += 26;
            }

            sb.append((char)('a' + nextChar));
        }
        return sb.toString();
    }
}
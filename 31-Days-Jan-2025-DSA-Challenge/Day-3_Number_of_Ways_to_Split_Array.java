Brute Force Solution :
Time Complexity  : O(N * N)
Space Complexity : O(1)

class Solution {
    public int waysToSplitArray(int[] nums) {
        int valid = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long leftSum = 0;
            long rightSum = 0;
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum >= rightSum) {
                valid++;
            }
        }
        return valid;
    }
}


Optimal Solution : 
Time Complexity  : O(N) + O(N)
Space Complexity : O(1)

class Solution {
    public int waysToSplitArray(int[] nums) {
        long leftSum = nums[0];
        long rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int valid = 0;
        if (leftSum >= rightSum) {
            valid++;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                valid++;
            }
        }
        return valid;
    }
}

import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 3 != 0) return new int[0][0];

        int[][] result = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) return new int[0][0]; 
            result[i / 3] = new int[]{a, b, c};
        }
        return result;
    }
}

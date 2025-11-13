import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0, i = 0;

        while (i < n) {
            int start = nums[i];
            count++;
            while (i < n && nums[i] - start <= k) {
                i++;
            }
        }

        return count;
    }
}

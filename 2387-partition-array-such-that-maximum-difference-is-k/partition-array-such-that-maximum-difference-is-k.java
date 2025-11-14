class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];

        for (int x : nums) {
            if (x - start > k) {
                count++;
                start = x;
            }
        }
        return count;
    }
}

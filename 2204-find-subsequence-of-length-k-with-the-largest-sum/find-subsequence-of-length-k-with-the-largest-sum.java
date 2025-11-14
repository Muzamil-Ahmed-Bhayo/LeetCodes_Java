class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2]; // [value, original_index]
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Sort by value descending
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        // Take first k elements
        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = pairs[i][1];
        }
        
        // Sort indices to preserve original order
        Arrays.sort(indices);
        
        // Build the result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[indices[i]];
        }
        
        return res;
    }
}

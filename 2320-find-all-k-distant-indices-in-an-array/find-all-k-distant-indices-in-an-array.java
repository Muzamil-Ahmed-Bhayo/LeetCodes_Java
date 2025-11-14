class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == key) keys.add(i);

        List<Integer> ans = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (idx < keys.size() && keys.get(idx) < i - k) idx++;
            if (idx < keys.size() && keys.get(idx) <= i + k) ans.add(i);
        }
        return ans;
    }
}

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c - 'a']++;

        int max = 0;
        for (int f : freq) if (f > max) max = f;

        int ans = Integer.MAX_VALUE;

        for (int target = 0; target <= max; target++) {
            int del = 0;
            for (int f : freq) {
                if (f < target) del += f;
                else if (f > target + k) del += f - (target + k);
            }
            ans = Math.min(ans, del);
        }

        return ans;
    }
}

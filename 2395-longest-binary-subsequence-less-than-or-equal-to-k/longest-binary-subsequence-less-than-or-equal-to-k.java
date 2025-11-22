class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0;
        int count = 0;
        long val = 0;
        long pow = 1;

        // Count all zeros (they always help increase length)
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        // Traverse from right (least significant bit)
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (pow > k) break;  // further bits too large
                if (val + pow <= k) {
                    val += pow;
                    count++;
                }
                pow <<= 1; // multiply by 2
            } else {
                pow <<= 1; // still move bit-position
            }
            if (pow > k + 1) break; 
        }

        return zeros + count;
    }
}

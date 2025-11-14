class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -1_000_000_000_000_000L, right = 1_000_000_000_000_000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLE(nums1, nums2, mid) < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    private long countLE(int[] a, int[] b, long x) {
        long count = 0;
        for (int v : a) {
            if (v > 0) {
                int l = 0, r = b.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)v * b[m] <= x) l = m + 1;
                    else r = m;
                }
                count += l;
            } else if (v < 0) {
                int l = 0, r = b.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)v * b[m] <= x) r = m;
                    else l = m + 1;
                }
                count += b.length - l;
            } else {
                if (x >= 0) count += b.length;
            }
        }
        return count;
    }
}

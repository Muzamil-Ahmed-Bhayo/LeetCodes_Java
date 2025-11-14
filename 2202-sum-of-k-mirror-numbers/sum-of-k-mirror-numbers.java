class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int found = 0;
        int length = 1;

        while (found < n) {
            int halfLen = (length + 1) / 2;
            long start = (long) Math.pow(10, halfLen - 1);
            long end = (long) Math.pow(10, halfLen);

            for (long half = start; half < end && found < n; half++) {
                long num = buildPalindrome(half, length % 2 == 1);
                if (isPalindrome(toBaseK(num, k))) {
                    sum += num;
                    found++;
                }
            }
            length++;
        }
        return sum;
    }

    private long buildPalindrome(long half, boolean odd) {
        long res = half;
        if (odd) half /= 10;
        while (half > 0) {
            res = res * 10 + (half % 10);
            half /= 10;
        }
        return res;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

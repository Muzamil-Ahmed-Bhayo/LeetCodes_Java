import java.util.*;

class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            List<Long> palindromes = generateBase10Palindromes(length);
            for (long num : palindromes) {
                if (isPalindrome(convertToBase(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            length++;
        }
        return sum;
    }

    private List<Long> generateBase10Palindromes(int length) {
        List<Long> res = new ArrayList<>();
        int halfLen = (length + 1) / 2;
        long start = (long) Math.pow(10, halfLen - 1);
        long end = (long) Math.pow(10, halfLen);

        for (long i = start; i < end; i++) {
            String s = String.valueOf(i);
            String rev = new StringBuilder(s.substring(0, length % 2 == 0 ? s.length() : s.length() - 1))
                            .reverse().toString();
            res.add(Long.parseLong(s + rev));
        }
        return res;
    }

    private String convertToBase(long num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

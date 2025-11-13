import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) list.add(f);
        }

        Collections.sort(list);
        int n = list.size();
        int ans = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + list.get(i);

        for (int i = 0; i < n; i++) {
            int targetMin = list.get(i);
            int maxAllowed = targetMin + k;
            int j = upperBound(list, maxAllowed);
            int delLeft = prefix[i];
            int delRight = (prefix[n] - prefix[j]) - (maxAllowed * (n - j));
            ans = Math.min(ans, delLeft + delRight);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int upperBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= val) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

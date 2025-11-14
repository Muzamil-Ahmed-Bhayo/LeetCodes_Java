class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            int d = Math.abs(x) + Math.abs(y);
            int t = i + 1;
            int use = Math.min(k, t);
            int cand = (int)Math.min(t, (long)d + 2L * use);
            if (cand > ans) ans = cand;
        }
        return ans;
    }
}

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] res = new String[groups];
        int idx = 0;
        
        for (int i = 0; i < n; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n) sb.append(s.charAt(j));
                else sb.append(fill);
            }
            res[idx++] = sb.toString();
        }
        return res;
    }
}

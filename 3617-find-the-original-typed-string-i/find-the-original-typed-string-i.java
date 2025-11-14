class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 1;
        int i = 0;
        
        while (i < n) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) j++;
            int len = j - i;
            ans += len - 1;
            i = j;
        }
        
        return ans;
    }
}

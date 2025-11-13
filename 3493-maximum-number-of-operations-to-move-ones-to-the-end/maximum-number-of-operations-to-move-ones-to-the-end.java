class Solution {
    public int maxOperations(String s) {
        int operations = 0;
        int onesCount = 0;
        char lastChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                onesCount++;
            } else { // c == '0'
                if (lastChar == '1') {
                    operations += onesCount;
                }
            }
            lastChar = c;
        }
        
        return operations;
    }
}
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char[] maxArr = s.toCharArray();
        char replaceMax = 0;
        for (char c : maxArr) {
            if (c != '9') {
                replaceMax = c;
                break;
            }
        }
        if (replaceMax != 0) {
            for (int i = 0; i < maxArr.length; i++) {
                if (maxArr[i] == replaceMax) maxArr[i] = '9';
            }
        }
        int a = Integer.parseInt(new String(maxArr));

       
        char[] minArr = s.toCharArray();
        char replaceMin = 0;
        char with = '0';

        if (minArr[0] != '1') {
            replaceMin = minArr[0];
            with = '1';
        } else {
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] != '0' && minArr[i] != '1') {
                    replaceMin = minArr[i];
                    with = '0';
                    break;
                }
            }
        }

        if (replaceMin != 0) {
            for (int i = 0; i < minArr.length; i++) {
                if (minArr[i] == replaceMin) minArr[i] = with;
            }
        }

        int b = Integer.parseInt(new String(minArr));

        return a - b;
    }
}

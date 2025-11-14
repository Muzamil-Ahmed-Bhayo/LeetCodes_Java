class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            diff[r1][c1]++;
            if (c2 + 1 < n) diff[r1][c2 + 1]--;
            if (r2 + 1 < n) diff[r2 + 1][c1]--;
            if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1]++;
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }


        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(diff[i], 0, result[i], 0, n);
        }

        return result;
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        if (k >= n) return 0;

        long comb = nCrMod(n - 1, k, MOD);
        long pow = modPow(m - 1, n - 1 - k, MOD);
        long res = comb * m % MOD * pow % MOD;
        return (int) res;
    }

    private long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod); // Fermat's little theorem
    }

    private long nCrMod(int n, int r, int mod) {
        if (r < 0 || r > n) return 0;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) % mod;
            res = res * modInverse(i, mod) % mod;
        }
        return res;
    }
}

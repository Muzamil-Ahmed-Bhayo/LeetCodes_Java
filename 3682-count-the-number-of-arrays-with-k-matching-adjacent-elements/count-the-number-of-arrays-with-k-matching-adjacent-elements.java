class Solution {
    static final int MOD = 1_000_000_007;
    private long pow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }
    private long nCr(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
       
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[n] = modInverse(fact[n]);
        for (int i = n - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        long res = m;
        res = (res * nCr(n - 1, k, fact, invFact)) % MOD;
        res = (res * pow(m - 1, n - 1 - k)) % MOD;

        return (int) res;
    }
}

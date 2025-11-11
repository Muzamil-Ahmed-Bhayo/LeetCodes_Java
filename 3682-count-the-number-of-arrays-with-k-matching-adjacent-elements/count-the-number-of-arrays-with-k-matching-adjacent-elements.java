class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long[] fact = new long[n];
        long[] invFact = new long[n];

        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = fact[i - 1] * i % MOD;

        invFact[n - 1] = modPow(fact[n - 1], MOD - 2);
        for (int i = n - 2; i >= 0; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        long comb = fact[n - 1] * invFact[k] % MOD * invFact[n - 1 - k] % MOD;
        long pow = modPow(m - 1, n - 1 - k);
        long ans = comb * m % MOD * pow % MOD;

        return (int) ans;
    }

    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}

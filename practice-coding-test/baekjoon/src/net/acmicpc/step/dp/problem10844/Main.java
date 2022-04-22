package net.acmicpc.step.dp.problem10844;

import java.util.Scanner;

public class Main {

    private static Long[][] dp;
    private static final long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0L;

        for (int i = 1; i < 10; i++) {
            result += recursive(N, i);
        }

        System.out.println(result % MOD);
    }

    private static long recursive(int N, int val) {
        if (dp[N][val] == null) {
            if (val == 0) {
                dp[N][val] = recursive(N - 1, 1);
            } else if (val == 9) {
                dp[N][val] = recursive(N - 1, 8);
            } else {
                dp[N][val] = recursive(N - 1, val - 1) + recursive(N - 1, val + 1);
            }
        }

        return dp[N][val] % MOD;
    }
}

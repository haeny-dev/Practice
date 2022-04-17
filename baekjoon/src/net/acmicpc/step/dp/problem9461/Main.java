package net.acmicpc.step.dp.problem9461;

import java.util.Scanner;

public class Main {

    private static long[] dp = new long[101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        while (T-- > 0) {
            int N = in.nextInt();
            System.out.println(recursive(N));
        }
    }

    private static long recursive(int N) {
        if (dp[N] == 0) {
            dp[N] = recursive(N - 1) + recursive(N - 5);
        }

        return dp[N];
    }
}

package net.acmicpc.step.dp.problem2579;

import java.util.Scanner;

public class Main {

    private static int[] step;
    private static Integer[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        step = new int[N + 1];
        dp = new Integer[N + 1];
        for (int i = 1; i <= N; i++) {
            step[i] = in.nextInt();
        }

        dp[0] = step[0] = 0;
        dp[1] = step[1];
        if (N >= 2) {
            dp[2] = step[2] + step[1];
        }

        System.out.println(climb(N));
    }
    private static int climb(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(climb(N - 2), climb(N - 3) + step[N - 1]) + step[N];
        }

        return dp[N];
    }
}

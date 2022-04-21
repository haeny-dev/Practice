package net.acmicpc.step.dp.problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;
        System.out.println(recursive(N));
    }

    private static int recursive(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(recursive(N - 1), Math.min(recursive(N / 3), recursive(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(recursive(N / 3), recursive(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(recursive(N / 2), recursive(N - 1)) + 1;
            } else {
                dp[N] = recursive(N - 1) + 1;
            }
        }

        return dp[N];
    }

    private static int recursive2(int N, int count) {
        if (N < 2) {
            return count;
        }

        return Math.min(
                recursive2(N / 2, count + 1 + (N % 2)),
                recursive2(N / 3, count + 1 + (N % 3))
                );
    }
}

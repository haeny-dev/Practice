package net.acmicpc.step.dp.problem12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Integer[][] dp;
    private static int[] W;
    private static int[] V;

    public static void main(String[] args) throws IOException {
        final String DELIM = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), DELIM);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new Integer[N + 1][K + 1];
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), DELIM);
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N, K));
    }

    private static int knapsack(int n, int k) {
        if (n <= 0) return 0;

        if (dp[n][k] == null) {
            if (W[n] > k) {
                dp[n][k] = knapsack(n - 1, k);
            } else {
                dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - W[n]) + V[n]);
            }
        }

        return dp[n][k];
    }
}

package net.acmicpc.step.dp.problem1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static Integer[] dp;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        sum(n - 1);

        System.out.println(max);
    }

    private static int sum(int N) {

        if (dp[N] == null) {
            dp[N] = Math.max(sum(N - 1) + arr[N], arr[N]);
            max = Math.max(max, dp[N]);
        }

        return dp[N];
    }
}

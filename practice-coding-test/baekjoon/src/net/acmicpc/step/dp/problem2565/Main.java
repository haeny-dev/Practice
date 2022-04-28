package net.acmicpc.step.dp.problem2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] dp;
    private static int[][] wires;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N];
        wires = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, find(i));
        }

        System.out.println(N - max);
    }

    private static int find(int N) {

        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N + 1; i < wires.length; i++) {

                if (wires[N][1] < wires[i][1]) {
                    dp[N] = Math.max(dp[N], find(i) + 1);
                }
            }
        }

        return dp[N];
    }
}

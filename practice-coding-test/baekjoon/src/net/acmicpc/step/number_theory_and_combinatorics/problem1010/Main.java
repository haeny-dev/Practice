package net.acmicpc.step.number_theory_and_combinatorics.problem1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combi(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    private static int combi(int n, int r) {

        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // nCn == nCo == 1
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // n+1Cr+1 == nCr + nCr+1 ==> nCr == n-1Cr-1 + n-1Cr
        return combi(n - 1, r - 1) + combi(n - 1, r);
    }
}

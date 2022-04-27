package net.acmicpc.step.dp.problem11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] rDp;
    private static Integer[] lDp;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        rDp = new Integer[N];
        lDp = new Integer[N];

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            max = Math.max(rDp[i] + lDp[i], max);
        }

        System.out.println(max - 1);
    }

    private static int LIS(int N) {

        if (rDp[N] == null) {
            rDp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    rDp[N] = Math.max(rDp[N], LIS(i) + 1);
                }
            }
        }

        return rDp[N];
    }

    private static int LDS(int N) {

        if (lDp[N] == null) {
            lDp[N] = 1;

            for (int i = N + 1; i < arr.length; i++) {
                if (arr[i] < arr[N]) {
                    lDp[N] = Math.max(lDp[N], LDS(i) + 1);
                }
            }
        }

        return lDp[N];
    }
}

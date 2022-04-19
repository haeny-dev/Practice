package net.acmicpc.step.dp.problem1904;

import java.util.Scanner;

public class Main {

    private static Integer[] counts = new Integer[1000001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println(recursive(N));
    }

    private static int recursive(int N) {
        if (N == 0) {
            return counts[0] = 0;
        }

        if (N == 1) {
            return counts[1] = 1;
        }

        if (N == 2) {
            return counts[2] = 2;
        }

        if (counts[N] == null) {
            counts[N] = (recursive(N - 1) + recursive(N - 2)) % 15746;
        }

        return counts[N];
    }

    private static int loop(int N) {
        if(N == 1) return 1;
        if(N == 2) return 2;

        int v1 = 1;
        int v2 = 2;
        int sum = 0;

        for (int i = 2; i < N; i++) {
            sum = (v1 + v2) % 15746;
            v1 = v2;
            v2 = sum;
        }

        return sum;
    }
}

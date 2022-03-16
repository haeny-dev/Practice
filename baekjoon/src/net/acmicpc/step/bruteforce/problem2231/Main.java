package net.acmicpc.step.bruteforce.problem2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int M = Integer.MAX_VALUE;

        for (int i = N; i > 0; i--) {
            int temp = i;
            int sum = i;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                M = i;
            }
        }

        System.out.print(M == Integer.MAX_VALUE ? 0 : M);
    }
}

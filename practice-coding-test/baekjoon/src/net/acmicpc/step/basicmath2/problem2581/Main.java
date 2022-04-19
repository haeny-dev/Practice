package net.acmicpc.step.basicmath2.problem2581;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        boolean[] isNotPrime = new boolean[N + 1];
        makePrimeMatrix(isNotPrime, N);

        int min = -1;
        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                if (min == -1) {
                    min = i;
                }

                sum += i;
            }
        }

        if (sum == 0) {
            System.out.print(min);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }
    }

    private static void makePrimeMatrix(boolean[] isNotPrime, int N) {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isNotPrime.length); i++) {

            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}

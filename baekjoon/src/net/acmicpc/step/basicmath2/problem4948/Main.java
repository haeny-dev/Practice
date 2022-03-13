package net.acmicpc.step.basicmath2.problem4948;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrimeMatrix = createIsNotPrimeMatrix(123456 * 2);
        StringBuilder sb = new StringBuilder();

        int N = readInt();
        while (N != 0) {
            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (!isNotPrimeMatrix[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
            N = readInt();
        }

        System.out.print(sb);
    }

    private static boolean[] createIsNotPrimeMatrix(int N) {
        boolean[] isNotPrime = new boolean[N + 1];

        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i + i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }

        return isNotPrime;
    }

    static int readInt() throws IOException {
        boolean isNegative = false;
        int sum = 0;
        while (true) {
            int input = System.in.read();
            if(input == '\n' || input == ' '){
                return isNegative ? -1 * sum : sum;
            } else if (input == '-') {
                isNegative = true;
            } else {
                sum = (sum * 10) + (input - '0');
            }
        }
    }
}

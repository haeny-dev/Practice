package net.acmicpc.step.basicmath2.problem9020;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrimeMatrix = createIsNotPrimeMatrix(10000);
        int T = readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = readInt();

            int firstPartition = N / 2;
            int secondPartition = N / 2;

            while (isNotPrimeMatrix[firstPartition] || isNotPrimeMatrix[secondPartition]) {
                firstPartition--;
                secondPartition++;
            }

            sb.append(firstPartition).append(" ").append(secondPartition).append("\n");
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

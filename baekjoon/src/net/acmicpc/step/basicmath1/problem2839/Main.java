package net.acmicpc.step.basicmath1.problem2839;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        if (N == 4 || N == 7) {
            System.out.print(-1);
        } else if (N % 5 == 0) {
            System.out.print(N / 5);
        } else if (N % 5 == 1 || N % 5 == 3) {
            System.out.print(N / 5 + 1);
        } else if (N % 5 == 2 || N % 5 == 4) {
            System.out.print(N / 5 + 2);
        }
    }

    static int readInt() throws IOException {
        boolean isNegative = false;
        int sum = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ') {
                return isNegative ? -1 * sum : sum;
            } else if (input == '-') {
                isNegative = true;
            } else {
                sum = (sum * 10) + (input - '0');
            }
        }
    }
}

package net.acmicpc.step.basicmath1.problem2775;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] apt = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }

        int T = readInt();
        for (int i = 0; i < T; i++) {
            int k = readInt();
            int n = readInt();
            System.out.println(apt[k][n]);
        }
    }

    static int readInt() throws IOException, IOException {
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

package net.acmicpc.step.array.problem1546;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] scores = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            scores[i] = readInt();
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        double sum = 0;
        for (int score : scores) {
            sum += (double) score * 100/max;
        }
        System.out.print(sum/n);
    }

    static int readInt() throws IOException{
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

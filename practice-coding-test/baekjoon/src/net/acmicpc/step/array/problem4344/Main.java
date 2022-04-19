package net.acmicpc.step.array.problem4344;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int c = readInt();

        for (int i = 0; i < c; i++) {
            int n = readInt();
            int[] scores = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                scores[j] = readInt();
                sum += scores[j];
            }
            double avg = (double) sum / n;
            double count = 0;
            for (int score : scores) {
                if (score > avg) {
                    count++;
                }
            }
            bw.write(String.format("%.3f", (count * 100/n)) + "%\n");
        }
        bw.flush();
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

package net.acmicpc.step.sort.problem10989;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] count = new int[10001];

        int N = readInt();
        for (int i = 0; i < N; i++) {
            int idx = readInt();
            count[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb);
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

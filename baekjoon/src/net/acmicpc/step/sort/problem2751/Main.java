package net.acmicpc.step.sort.problem2751;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[2000001];
        int N = readInt();
        for (int i = 0; i < N; i++) {
            arr[readInt() + 1000000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                sb.append(i - 1000000).append("\n");
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

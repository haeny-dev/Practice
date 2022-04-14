package net.acmicpc.step.dp.problem1003;

import java.io.IOException;

public class Main {

    private static Integer[][] counts = new Integer[41][2];

    public static void main(String[] args) throws IOException {

        int T = readInt();

        counts[0][0] = 1;
        counts[0][1] = 0;
        counts[1][0] = 0;
        counts[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int N = readInt();
            fibo(N);
            System.out.println(counts[N][0] + " " + counts[N][1]);
        }
    }

    private static Integer[] fibo(int N) {

        if (counts[N][0] == null || counts[N][1] == null) {
            counts[N][0] = fibo(N - 2)[0] + fibo(N - 1)[0];
            counts[N][1] = fibo(N - 2)[1] + fibo(N - 1)[1];
        }

        return counts[N];
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

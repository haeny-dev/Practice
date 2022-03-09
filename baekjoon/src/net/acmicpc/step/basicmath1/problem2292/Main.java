package net.acmicpc.step.basicmath1.problem2292;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int count = 0;
        double a = 0;
        double b = 1;
        while (!(a < N && N <= b)) {
            a = b;
            b = a + 6 * ++count;
        }

        System.out.print(++count);
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

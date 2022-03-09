package net.acmicpc.step.basicmath1.problem1193;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int X = readInt();
        int a = 0;
        int b = 1;
        int count = 1;
        while (!(a < X && X <= b)) {
            a = b;
            b = a + ++count;
        }

        int top;
        int bottom;
        if (count % 2 == 0) {
            top = 1;
            bottom = count;
            for (int i = 0; i < X - a - 1; i++) {
                top++;
                bottom--;
            }
        } else {
            top = count;
            bottom = 1;
            for (int i = 0; i < X - a - 1; i++) {
                top--;
                bottom++;
            }
        }

        System.out.print(top + "/" + bottom);
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

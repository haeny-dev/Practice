package net.acmicpc.step.array.problem2562;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            int n = readInt();
            if (n > max) {
                max = n;
                idx = i;
            }
        }

        bw.write(max + "\n" + (idx+1));
        bw.flush();
        bw.close();
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

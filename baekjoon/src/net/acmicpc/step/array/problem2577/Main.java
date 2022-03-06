package net.acmicpc.step.array.problem2577;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int n = readInt() * readInt() * readInt();
        while(n != 0){
            count[n%10]++;
            n /= 10;
        }
        for (int c : count) {
            bw.write(c + "\n");
        }
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

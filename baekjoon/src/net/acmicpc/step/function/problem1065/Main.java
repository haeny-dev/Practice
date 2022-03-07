package net.acmicpc.step.function.problem1065;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        boolean[] isHansoo = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            isHansoo[i] = isHansoo(i);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(isHansoo[i]){
                count++;
            }
        }

        System.out.print(count);
    }

    private static boolean isHansoo(int i) {
        if (i < 100) return true;

        int curr = i % 10;
        i /= 10;
        int next = i % 10;
        i /= 10;

        int difference = next - curr;
        while (i != 0) {
            curr = next;
            next = i % 10;
            i /= 10;
            if (next - curr != difference) {
                return false;
            }
        }

        return true;
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

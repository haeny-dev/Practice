package net.acmicpc.step.sort.problem2108;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] counts = new int[8001];
        StringBuilder sb = new StringBuilder();

        int N = readInt();

        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = readInt();
            sum += num;
            counts[num + 4000]++;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        int middleCount = 0;
        int middle = 0;
        int maxCount = 0;
        boolean isSecond = false;
        int maxCountValue = 0;
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (counts[i] > 0) {

                if (middleCount < N / 2 + 1) {
                    middleCount += counts[i];
                    middle = i - 4000;
                }

                if (counts[i] > maxCount) {
                    maxCount = counts[i];
                    maxCountValue = i - 4000;
                    isSecond = true;
                } else if (counts[i] == maxCount && isSecond) {
                    maxCountValue = i - 4000;
                    isSecond = false;
                }
            }
        }

        System.out.println((int) Math.round(sum / N));
        System.out.println(middle);
        System.out.println(maxCountValue);
        System.out.println(max - min);
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

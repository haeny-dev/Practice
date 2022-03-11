package net.acmicpc.step.basicmath2.problem1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrimeNumber(num)) {
                count++;
            }
        }

        System.out.print(count);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

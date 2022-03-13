package net.acmicpc.step.basicmath2.problem1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[N + 1];
        createIsNotPrimeMatrix(N, isNotPrime);

        for (int i = M; i < N + 1; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }

    private static void createIsNotPrimeMatrix(int N, boolean[] isNotPrime) {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i + i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}

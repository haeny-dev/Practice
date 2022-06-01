package net.acmicpc.step.number_theory_and_combinatorics.problem3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int n = 1;

            while ((n * arr[0]) % arr[i] != 0) {
                n++;
            }

            System.out.println((n * arr[0] / arr[i]) + "/" + n);
        }
    }
}

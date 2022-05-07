package net.acmicpc.step.cumulative_sum.problem10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] mod = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken()) % M;
            mod[sum % M]++;
        }

        long result = mod[0];
        for (int i = 0; i < M; i++) {
            result += (long)mod[i] * (mod[i] - 1)/2;
        }

        System.out.println(result);
    }
}

package net.acmicpc.step.greedy.problem13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] lengths = new int[N - 1];
        int[] prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = prices[0];
        long result = 0;

        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            result += (long) minPrice * lengths[i];
        }

        System.out.println(result);
    }
}

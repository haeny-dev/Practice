package net.acmicpc.step.bruteforce.problem7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && weights[i] < weights[j] && heights[i] < heights[j]) {
                    cnt++;
                }
            }
            sb.append(++cnt).append(" ");
        }
        System.out.print(sb);
    }
}

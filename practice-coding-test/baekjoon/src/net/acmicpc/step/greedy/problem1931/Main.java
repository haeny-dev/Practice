package net.acmicpc.step.greedy.problem1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (t1, t2) -> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }

            return t1[1] - t2[1];
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (endTime <= times[i][0]) {
                endTime = times[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

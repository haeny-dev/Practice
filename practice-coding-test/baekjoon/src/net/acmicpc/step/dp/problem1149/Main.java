package net.acmicpc.step.dp.problem1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] result = Arrays.stream(costs)
                .reduce(new int[]{0, 0, 0},
                        (a, b) -> new int[]{
                                b[0] + Math.min(a[1], a[2]),
                                b[1] + Math.min(a[0], a[2]),
                                b[2] + Math.min(a[0], a[1])
                        });

        System.out.println(Math.min(result[0], Math.min(result[1], result[2])));
    }
}

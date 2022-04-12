package net.acmicpc.step.backtracking.problem14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int[] visited;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }

        operation(N, 0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void operation(int N, int depth, int value) {
        if (depth == N - 1) {
            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                operation(N, depth + 1, getNewValue(value, arr[depth + 1], i));
                visited[i]++;
            }
        }
    }

    private static int getNewValue(int value, int nextVal, int i) {
        if (i == 0) {
            value += nextVal;
        } else if (i == 1) {
            value -= nextVal;
        } else if (i == 2) {
            value *= nextVal;
        } else {
            value /= nextVal;
        }

        return value;
    }
}

package net.acmicpc.step.dp.problem1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n];

        for (int row = 1; row <= n; row++) {
            String[] tokens = br.readLine().split(" ");

            for (int col = 0; col < tokens.length; col++) {
                int num = Integer.parseInt(tokens[col]);

                if (col == 0) {
                    arr[row][col] = arr[row - 1][col] + num;
                } else if (col == tokens.length - 1) {
                    arr[row][col] = arr[row - 1][col - 1] + num;
                } else {
                    arr[row][col] = Math.max(arr[row - 1][col - 1] + num, arr[row - 1][col] + num);
                }
            }
        }

        System.out.println(Arrays.stream(arr[n]).max().getAsInt());
    }
}

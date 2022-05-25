package net.acmicpc.step.geometry.problem2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] directions = new int[6];
        int[] values = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directions[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int maxArea = Math.max(values[0], Math.max(values[2], values[4])) * Math.max(values[1], Math.max(values[3], values[5]));
        int excludeArea = 0;

        for (int i = 0; i < 6; i++) {
            if ((directions[i] == 1 && directions[(i + 1) % 6] == 3)
                    || (directions[i] == 2 && directions[(i + 1) % 6] == 4)
                    || (directions[i] == 3 && directions[(i + 1) % 6] == 2)
                    || (directions[i] == 4 && directions[(i + 1) % 6] == 1)) {
                excludeArea = values[i] * values[(i + 1) % 6];
            }
        }
        System.out.println((maxArea - excludeArea) * K);
    }
}


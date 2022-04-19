package net.acmicpc.step.backtracking.problem14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] abilities;
    private static boolean[] selected;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        selected = new boolean[N];
        abilities = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combiTeam(0, 0);
        System.out.println(min);
    }

    private static void combiTeam(int count, int idx) {
        if (count == N/2) {
            difference();
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!selected[i]){
                selected[i] = true;
                combiTeam(count + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    private static void difference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startTeam += abilities[i][j] + abilities[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkTeam += abilities[i][j] + abilities[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam);

        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(diff, min);
    }
}

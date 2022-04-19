package net.acmicpc.step.sort.problem18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);
        int rank = 0;
        for (int x : sorted) {
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : origin) {
            sb.append(rankMap.get(x)).append(" ");
        }

        System.out.print(sb);
    }
}

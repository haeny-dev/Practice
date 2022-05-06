package net.acmicpc.step.cumulative_sum.problem16139.another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        sum = new int[s.length()][26];
        sum[0][s.charAt(0) - 'a']++;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }

            sum[i][s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(count(alpha, l, r)).append("\n");
        }
        System.out.println(sb);
    }

    private static int count(char alpha, int l, int r) {
        return l == 0 ? sum[r][alpha - 'a'] : sum[r][alpha - 'a'] - sum[l - 1][alpha - 'a'];
    }
}

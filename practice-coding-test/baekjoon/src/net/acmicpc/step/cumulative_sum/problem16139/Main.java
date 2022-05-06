package net.acmicpc.step.cumulative_sum.problem16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(count(a, l, r));
        }
    }

    private static int count(char a, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (chars[i] == a) {
                count++;
            }
        }
        return count;
    }
}

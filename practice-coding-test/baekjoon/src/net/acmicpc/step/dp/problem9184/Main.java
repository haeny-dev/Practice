package net.acmicpc.step.dp.problem9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] w = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String readLine = null;
        while ((readLine = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(readLine, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("w(").append(a)
                    .append(", ").append(b)
                    .append(", ").append(c)
                    .append(") = ");

            sb.append(w(a, b, c));
            System.out.println(sb);
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (w[a][b][c] != 0){
            return w[a][b][c];
        }

        if (a < b && b < c) {
            return w[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return w[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}

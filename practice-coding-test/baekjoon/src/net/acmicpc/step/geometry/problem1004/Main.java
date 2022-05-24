package net.acmicpc.step.geometry.problem1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());

            int count = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if ((containsPoint(x, y, r, x1, y1) && !containsPoint(x, y, r, x2, y2))
                        || (!containsPoint(x, y, r, x1, y1) && containsPoint(x, y, r, x2, y2))) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean containsPoint(int x, int y, int r, int x1, int y1) {
        return r * r > Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y - y1), 2);
    }
}

package net.acmicpc.step.geometry.problem1358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int W;
    private static int H;
    private static int X;
    private static int Y;
    private static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        R = H / 2;

        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (contains(x, y)){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean contains(int x, int y) {

        if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
            return true;
        }

        if (x <= X && (R * R >= getDistancePow(x, y, X, Y + R))){
            return true;
        }

        if(x >= X + W && (R * R >= getDistancePow(x, y, X + W, Y + R))){
            return true;
        }

        return false;
    }

    private static double getDistancePow(int x, int y, int X, int Y) {
        return Math.pow(Math.abs(x - X), 2) + Math.pow(Math.abs(y - Y), 2);
    }
}

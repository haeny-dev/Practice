package net.acmicpc.step.ifstatement.problem2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(br.readLine());
        if (m >= 60) {
            h += m / 60;
            h = h > 23 ? h - 24 : h;
            m %= 60;
        }
        System.out.print(h + " " + m);
    }
}

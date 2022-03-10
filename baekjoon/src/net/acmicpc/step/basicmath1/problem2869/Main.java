package net.acmicpc.step.basicmath1.problem2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        /**
         *
         * A * D - (B * (D - 1)) >= V
         * A * D - (B * D - B) >= V
         * A * D - B * D + B >= V
         * D( A - B) >= V - B
         * D >= V-B / A-B
         */


        System.out.print( (V-B)%(A-B) == 0 ? (V-B)/(A-B) : (V-B)/(A-B) + 1);
    }
}

package net.acmicpc.step.basicmath1.problem1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        int n = 0;
        if (B >= C) {
            System.out.print(-1);
            return;
        }
        while(A + B * n >= C * n){
            n++;
        }
        System.out.print(n);
    }
}

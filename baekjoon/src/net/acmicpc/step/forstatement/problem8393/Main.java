package net.acmicpc.step.forstatement.problem8393;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print((n * (1 + n))/2);
    }
}

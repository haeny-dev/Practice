package net.acmicpc.step.string.problem1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        if (s.isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.print(s.split(" ").length);
    }
}

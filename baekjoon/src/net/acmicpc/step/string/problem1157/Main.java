package net.acmicpc.step.string.problem1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 65]++;
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max && maxIdx != i) {
                System.out.print("?");
                return;
            }
        }

        System.out.print((char)(maxIdx + 65));
    }
}

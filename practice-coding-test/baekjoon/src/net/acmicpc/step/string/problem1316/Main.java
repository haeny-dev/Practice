package net.acmicpc.step.string.problem1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (checkGroupWord(br.readLine())) {
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean checkGroupWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            int nextIdx = word.indexOf(word.charAt(i), i + 1);
            if (nextIdx != -1 && nextIdx != i + 1) {
                return false;
            }
        }
        return true;
    }
}

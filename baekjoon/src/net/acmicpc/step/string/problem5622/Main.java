package net.acmicpc.step.string.problem5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] dial = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (char c : br.readLine().toCharArray()) {
            for (int i = 2; i < dial.length; i++) {
                if (dial[i].contains(String.valueOf(c))) {
                    sum += i + 1;
                    break;
                }
            }
        }
        System.out.print(sum);
    }
}

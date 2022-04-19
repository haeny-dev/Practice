package net.acmicpc.step.sort.problem1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Arrays.sort(chars);
        System.out.print(new StringBuilder(String.valueOf(chars)).reverse());
    }
}

package net.acmicpc.step.set_and_map.problem11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Set<String> set = new HashSet<>();

        for (int length = 1; length <= S.length(); length++) {
            for (int i = 0; i <= S.length() - length; i++) {
                set.add(S.substring(i, i + length));
            }
        }

        System.out.println(set.size());
    }
}

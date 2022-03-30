package net.acmicpc.step.sort.problem1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.stream()
                .sorted((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length())
                .forEach(System.out::println);
    }
}

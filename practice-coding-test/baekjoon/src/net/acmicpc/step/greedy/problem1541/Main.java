package net.acmicpc.step.greedy.problem1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = getSumOfNumberInToken(st.nextToken());

        while (st.hasMoreTokens()) {
            result -= getSumOfNumberInToken(st.nextToken());
        }

        System.out.println(result);
    }

    private static int getSumOfNumberInToken(String token) {
        int result = 0;
        StringTokenizer st = new StringTokenizer(token, "+");
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

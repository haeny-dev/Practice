package net.acmicpc.step.problem2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String bLine = br.readLine();
        int b = Integer.parseInt(bLine);
        String[] split = bLine.split("");
        System.out.println(a * Integer.parseInt(split[2]));
        System.out.println(a * Integer.parseInt(split[1]));
        System.out.println(a * Integer.parseInt(split[0]));
        System.out.print(a * b);
    }
}

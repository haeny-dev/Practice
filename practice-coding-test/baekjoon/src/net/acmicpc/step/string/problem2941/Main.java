package net.acmicpc.step.string.problem2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine()
                .replaceAll("c=", "1")
                .replaceAll("c-", "2")
                .replaceAll("dz=", "3")
                .replaceAll("d-", "4")
                .replaceAll("lj", "5")
                .replaceAll("nj", "6")
                .replaceAll("s=", "7")
                .replaceAll("z=", "8");
        System.out.print(s.length());
    }
}

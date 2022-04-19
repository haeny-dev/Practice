package net.acmicpc.step.whilestatement.problem1110;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        int convert = n;

        do {
            int pre = convert % 10;

            if (convert < 10) {
                convert *= 10;
            }

            int suf = (convert / 10 + convert % 10) % 10;

            convert = pre * 10 + suf;

            count++;
        } while (convert != n);

        System.out.print(count);
    }
}

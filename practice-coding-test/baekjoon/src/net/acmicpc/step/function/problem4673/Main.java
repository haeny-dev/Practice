package net.acmicpc.step.function.problem4673;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 10000 ; i++) {
            set.add(i);
        }

        for (int i = 1; i <= 10000; i++) {
            set.remove(d(i));
        }
        StringBuilder sb = new StringBuilder();
        set.forEach(x -> sb.append(x).append("\n"));
        bw.write(sb.toString());
        bw.flush();
    }

    private static int d(int n) {
        int answer = n;
        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}

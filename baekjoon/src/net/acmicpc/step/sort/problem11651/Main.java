package net.acmicpc.step.sort.problem11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.sort((a, b) -> {
            StringTokenizer st = new StringTokenizer(a, " ");
            int xa = Integer.parseInt(st.nextToken());
            int ya = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(b, " ");
            int xb = Integer.parseInt(st.nextToken());
            int yb = Integer.parseInt(st.nextToken());

            return ya == yb ? xa - xb : ya - yb;
        });

        System.out.print(String.join("\n", list));
    }
}

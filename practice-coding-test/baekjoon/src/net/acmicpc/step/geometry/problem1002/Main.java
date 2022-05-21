package net.acmicpc.step.geometry.problem1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 접점의 개수가 무한대 일 때 -> 두 원의 중심이 같고 반지름도 같을 때
 *      => x1 = x2, y1 = y2, r1 = r2
 *
 * 2. 접점이 없을 때
 *
 *    1) 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때
 *      => (x2 - x1)^2 + (y2 - y1)^2 > (r1 + r2)^2
 *
 *    2) 한 원 안에 다른 원이 있으면서 접점이 없을 때
 *      => (x2 - x1)^2 + (y2 - y1)^2 < (r2 - r1)^2
 *
 * 3. 접점이 한 개일 때
 *
 *    1) 내접할 때
 *      => (x2 - x1)^2 + (y2 - y1)^2 = (r2 - r1)^2
 *
 *    2) 외접할 때
 *      => (x2 - x1)^2 + (y2 - y1)^2 = (r2 + r1)^2
 *
 * 4. 그외 -> 접점 2개
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(getCountContactPoint(x1, y1, r1, x2, y2, r2)).append("\n");
        }
        System.out.print(sb);
    }

    private static int getCountContactPoint(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distancePow = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        } else if (distancePow > Math.pow(r1 + r2, 2)) {
            return 0;
        } else if (distancePow < Math.pow(r2 - r1, 2)) {
            return 0;
        } else if (distancePow == Math.pow(r2 - r1, 2)) {
            return 1;
        } else if (distancePow == Math.pow(r2 + r1, 2)) {
            return 1;
        } else {
            return 2;
        }
    }
}

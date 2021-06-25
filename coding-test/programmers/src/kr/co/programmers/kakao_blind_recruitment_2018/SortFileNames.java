package kr.co.programmers.kakao_blind_recruitment_2018;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortFileNames {

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(new Solution().solution(files)));
    }

    static class Solution {
        public String[] solution(String[] files) {
            return Arrays.stream(files).sorted((a, b) -> {
                a = a.toLowerCase();
                b = b.toLowerCase();

                int i = 0;
                int j = 0;

                while (i < a.length() && !Character.isDigit(a.charAt(i))) i++;
                while (j < b.length() && !Character.isDigit(b.charAt(j))) j++;

                int headCompare = a.substring(0, i).compareTo(b.substring(0, j));
                if (headCompare != 0) {
                    return headCompare;
                }

                int sIdxA = i;
                int sIdxB = j;

                while (i < a.length() && Character.isDigit(a.charAt(i))) i++;
                while (j < b.length() && Character.isDigit(b.charAt(j))) j++;

                return Integer.parseInt(a.substring(sIdxA, i)) - Integer.parseInt(b.substring(sIdxB, j));
            }).collect(Collectors.toList()).toArray(new String[files.length]);
        }
    }
}

package kr.co.programmers.java.practice;

import java.time.LocalDate;

public class Year2016 {

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(new Solution().solution(a, b));
    }

    static class Solution {
        public String solution(int a, int b) {
            LocalDate localDate = LocalDate.of(2016, a, b);
            return CustomDayOfWeek.of(localDate.getDayOfWeek().getValue()).toString();
        }

        public enum CustomDayOfWeek{
            MON,TUE,WED,THU,FRI,SAT,SUN;

            private static final CustomDayOfWeek[] ENUMS = values();

            public static CustomDayOfWeek of(int var0) {
                if (var0 >= 1 && var0 <= 7) {
                    return ENUMS[var0 - 1];
                } else {
                    throw new RuntimeException("Invalid value for DayOfWeek: " + var0);
                }
            }
        }
    }
}

package com.codility.lessons.lesson3;

public class FrogJmp {

    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        System.out.println(new Solution().solution(X, Y, D));
    }

    static class Solution{

        public int solution(int X, int Y, int D){

            return (int) Math.ceil((double)(Y - X) / D);
        }

    }
}

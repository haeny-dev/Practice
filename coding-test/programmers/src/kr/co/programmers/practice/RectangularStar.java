package kr.co.programmers.practice;

import java.util.Scanner;

public class RectangularStar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String stars = "";
        while(a > 0){
            stars += "*";
            a--;
        }

        while(b > 0){
            System.out.println(stars);
            b--;
        }
    }
}

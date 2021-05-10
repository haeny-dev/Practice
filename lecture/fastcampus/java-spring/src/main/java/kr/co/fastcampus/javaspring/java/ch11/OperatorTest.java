package kr.co.fastcampus.javaspring.java.ch11;

public class OperatorTest {

    public static void main(String[] args) {

        int gameScore = 150;
        int lastScore = ++gameScore;

        System.out.println(lastScore);
        System.out.println(gameScore);

        lastScore = gameScore++;

        System.out.println(lastScore);
        System.out.println(gameScore);
    }
}

package kr.co.fastcampus.javaspring.java.ch20;

public class NestedLoopTest {

    public static void main(String[] args) {

        int dan = 2;
        int count;

        for(; dan <= 9; dan++){
            for(count = 1; count <= 9; count++){
                System.out.println(dan + " X " + count + " = " + dan * count);
            }
            System.out.println();
        }
    }
}

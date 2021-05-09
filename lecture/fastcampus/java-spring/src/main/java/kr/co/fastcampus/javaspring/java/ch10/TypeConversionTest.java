package kr.co.fastcampus.javaspring.java.ch10;

public class TypeConversionTest {

    public static void main(String[] args) {

        byte bNum = 125;
        int iNum = bNum;
        System.out.println(iNum);

        iNum = 255;
        bNum = (byte) iNum;
        System.out.println(bNum);

        double dNum = 3.14;
        iNum = (int) dNum;
        System.out.println(iNum);

        dNum = 1.2;
        float fNum = 0.9F;

        int iNum1 = (int)dNum + (int)fNum;
        int iNum2 = (int)(dNum + fNum);

        System.out.println(iNum1);
        System.out.println(iNum2);
    }
}

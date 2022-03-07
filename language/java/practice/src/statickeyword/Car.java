package statickeyword;

public class Car {

    private static final int GENERATE_YEAR = 2022;

    public Car() {
    }

    public static class Wheel {

        private int changeYear;

        public Wheel() {
            changeYear = GENERATE_YEAR;
        }
    }

}

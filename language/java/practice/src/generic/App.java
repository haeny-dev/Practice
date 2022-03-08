package generic;

public class App {
    public static void main(String[] args) {
        Box<Integer> bi;
        bi = createBox();
    }

    private static Box createBox() {
        return new Box();
    }

    private static void rawTypesTest() {
        // 원시 타입(Raw Type)
        Box rawBox = new Box();

        // 제네릭 타입
        Box<String> stringBox = new Box<>();

        // 경고: 확인되지 않은 변환
        rawBox = new Box();
        Box<Integer> integerBox = rawBox;

        // 할당 허용
        rawBox = stringBox;

        // 경고
        rawBox.setT(8);
    }
}

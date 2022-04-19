package java8.default_method;

/**
 * Person과 Named 둘 다 getName() 이라는 디폴트 메서드를 가지고 있을 경우
 * 충돌이 발생하여 컴파일에러를 발생시킨다. 이를 해결하기 위해 재정의를 해줘야 한다.
 * 둘 중 하나라도 인터페이스에서 구현을 제공하면 컴파일러는 오류를 보고하고 해결하도록 강제한다.
 */
public class Student implements Person, Named{

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return Person.super.getName();
    }
}

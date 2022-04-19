package basic.generic;

import java.util.List;

public class WildcardError {

    void foo(List<?> list) {
//        list.set(0, list.get(0)); // 컴파일 에러: capture of
        fooHelper(list);
    }

    private <T> void fooHelper(List<T> list) {
        list.set(0, list.get(0));
    }
}

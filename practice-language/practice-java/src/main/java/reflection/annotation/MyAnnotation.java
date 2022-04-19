package reflection.annotation;

import java.lang.annotation.*;

/**
 * @Retention -> 해당 애노테이션을 언제까지 유지할 것인가? 기본값은 CLASS
 * @Inherit -> 해당 애노테이션을 하위 클래스까지 전달할 것인가?
 * @Target  -> 어디에 사용할 수 있는가?
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    /**
     * value는 생략이 가능 합니다.
     * @MyAnnotation(value = "value") -> @MyAnnotation("value")
     */
    String value() default "default";
    int number() default 100;
}

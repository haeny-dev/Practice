package java8.default_method;

public interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}

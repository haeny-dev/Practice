package java8.interface_default_method;

public interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}

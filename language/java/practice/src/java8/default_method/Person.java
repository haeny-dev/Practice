package java8.default_method;

public interface Person {
    long getId();
    default String getName(){
        return "John Q. Public";
    }
}
 
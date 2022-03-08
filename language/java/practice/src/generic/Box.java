package generic;

/**
 * Generic version of the Box class
 * @param <T>
 */
public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

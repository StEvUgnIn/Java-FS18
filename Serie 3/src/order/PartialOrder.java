package order;

public interface PartialOrder<T> {
    /**
     * lesser or equals
     * @param that compared object
     * @return true or false
     */
    boolean leq (final PartialOrder<T> that);
}

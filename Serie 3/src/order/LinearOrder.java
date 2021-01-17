package order;

public interface LinearOrder<T>
        extends  PartialOrder<T> {
    /**
     * lesser than or equals
     * @param that compared object
     * @return true or false
     */
    boolean leq (final LinearOrder<T> that);
}

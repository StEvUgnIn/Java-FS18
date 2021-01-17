package order;

public interface StrictLinearOrder<T>
extends          LinearOrder<T>,
                 DiscreteOrder<T> {
    /**
     * lesser than that
     * @param that compared object
     * @return true or false
     */
    default boolean le (final StrictLinearOrder<T> that) {
        return this.leq(that) && !that.eq(this);
    }
}

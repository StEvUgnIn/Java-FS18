package order;

public interface StrictLinearOrder<T>
extends          LinearOrder<T>,
                 DiscreteOrder<T> {
    default boolean le (final StrictLinearOrder<T> that) {
        return (that.leq(this)) && le(that);
    }

    default boolean gr (final PartialOrder<T> that) {
        return ((StrictLinearOrder<T>)that).le(this) && leq(that);
    }
}

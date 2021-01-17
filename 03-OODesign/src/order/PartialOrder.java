package order;

public interface PartialOrder <T> {
    boolean leq (final PartialOrder<T> that);
    default  boolean gep (final PartialOrder<T> that) {
        return ((DiscreteOrder<T>)(StrictLinearOrder<T>)this).eq(
                (DiscreteOrder<T>)(StrictLinearOrder<T>) that
        ) && !leq(that);
    }
}

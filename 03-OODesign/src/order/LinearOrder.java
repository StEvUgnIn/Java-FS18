package order;

public interface LinearOrder <T>
        extends  PartialOrder<T> {
    boolean leq (final LinearOrder<T> that);

    @Override
    default boolean gep (final PartialOrder<T> that) {
        return gep(that);
    }
}

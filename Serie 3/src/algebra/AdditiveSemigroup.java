package algebra;

public interface AdditiveSemigroup<T> {
    /**
     * returns the sum of this object and the given argument
     * @param that given argument
     * @return the sum of this object and the given argument
     */
    AdditiveSemigroup<T> plus (final AdditiveSemigroup<T> that);
}

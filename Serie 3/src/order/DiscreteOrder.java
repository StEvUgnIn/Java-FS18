package order;

public interface DiscreteOrder <T> {
    /**
     * equals
     * @param that compared object
     * @return true or false
     */
    boolean eq (final DiscreteOrder<T> that);
}

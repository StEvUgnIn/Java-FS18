package algebra;

public interface AdditiveMonoid   <T>
        extends AdditiveSemigroup<T> {
	/**
	 * returns zero
	 * @return an object of value to be equal to zero
	 */
	AdditiveMonoid<T> getZero ();
}

package algebra;

public interface AdditiveGroup <T>
		extends  AdditiveMonoid<T> {

	/**
	 * return the absolute substracted value of this and that object
	 * @param that given argument
	 * @return the absolute substracted value of object and that object
	 */
	AdditiveGroup<T> minus (final AdditiveGroup<T> that);
}

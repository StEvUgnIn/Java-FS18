package algebra;

public interface AdditiveMonoid   <T>
        extends  AdditiveSemigroup<T> {
	AdditiveMonoid<T> getZero();

	default AdditiveMonoid<T> times(final AdditiveMonoid<T> that) {
        AdditiveSemigroup<T> result = getZero();
	    for (int i = 0; i != that.hashCode(); i++) {
	        result = result.plus(this);
        }
        return (AdditiveMonoid<T>) result;
	}
}

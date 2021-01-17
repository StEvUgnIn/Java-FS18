package algebra;

public interface AdditiveGroup <T>
		extends  AdditiveMonoid<T> {

	AdditiveGroup<T> getAddInv();

	default AdditiveGroup<T> minus (final AdditiveGroup<T> that) {
		return (AdditiveGroup<T>)(
				(AdditiveSemigroup<T>)this).plus(
				(AdditiveSemigroup<T>)that.getAddInv()
		);
	}

	default AdditiveGroup<T> times (final AdditiveGroup<T> that) {
		return (AdditiveGroup<T>)(
				(AdditiveMonoid<T>) this).times(
				(AdditiveMonoid<T>) that);
	}
}

package algebra;

public interface MultiplicativeMonoid<T> extends MultiplicativeSemigroup<T> {
	MultiplicativeMonoid<T> getOne();

	default MultiplicativeMonoid<T> pow (final MultiplicativeMonoid<T> that) {
        return ((CommutativeSemiring<T>)this).pow((CommutativeSemiring<T>)that);
	}
}

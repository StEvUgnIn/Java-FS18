package algebra;

public interface CommutativeSemiring <T>
extends          AdditiveMonoid <T>,
                 MultiplicativeMonoid <T> {

    default CommutativeSemiring<T> incr () {
        return (CommutativeSemiring<T>)this.plus((CommutativeSemiring<T>)getOne());
    }

    default CommutativeSemiring<T> pow (final CommutativeSemiring<T> that) {
        MultiplicativeSemigroup<T> result = getOne();

        for (int i = 0; i != that.hashCode(); i++) {
            result = result.times(this);
        }

        return (CommutativeSemiring<T>)result;
    }
}
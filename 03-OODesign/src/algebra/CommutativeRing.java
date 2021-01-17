package algebra;

public interface CommutativeRing <T>
	extends	CommutativeSemiring  <T>,
	AdditiveGroup                <T> {

	default CommutativeRing<T> decr() {
        return (CommutativeRing<T>)minus((CommutativeRing<T>)getOne());
	}
}

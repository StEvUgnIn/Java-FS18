package numbers.rationals.integers.naturals.peano;
import  numbers.rationals.integers.naturals.NaturalNumber;

import order.*;

public final class Zero extends PeanoNatural {

    public final boolean eq (
        final DiscreteOrder<NaturalNumber> that) {
        return (that instanceof Zero);
    }

    public final NaturalNumber getPred () {
        return null;
    }

    public final int hashCode () {
        return 0;
    }
}

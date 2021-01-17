package numbers.integers.naturals.peano;
import numbers.integers.naturals.NaturalNumber;

import order.DiscreteOrder;

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

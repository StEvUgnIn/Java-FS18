package numbers.integers.naturals.peano;
import numbers.integers.naturals.NaturalNumber;

import algebra.*;
import order.*;


public abstract class PeanoNatural extends NaturalNumber {

    public final AdditiveSemigroup<NaturalNumber> plus (
           final AdditiveSemigroup<NaturalNumber> that) {
        return this.plus(that, new Succ(this));
    }

    public final AdditiveGroup<NaturalNumber> minus (
            final AdditiveGroup<NaturalNumber> that) {
        return this.minus(that, this.getPred());
    }

    public boolean leq (
            final PartialOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((PeanoNatural)that).isZero())  return false;
        return this.getPred().leq(((PeanoNatural)that).getPred());
    }
}

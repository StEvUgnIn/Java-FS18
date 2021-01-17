package numbers.rationals.integers.naturals.peano;
import  numbers.rationals.integers.naturals.NaturalNumber;

import algebra.AdditiveSemigroup;
import order.PartialOrder;


public abstract class PeanoNatural extends NaturalNumber {

    public final AdditiveSemigroup<NaturalNumber> plus (
           final AdditiveSemigroup<NaturalNumber> that) {
        return this.plus(that, new Succ(this));
    }

    public boolean leq (PartialOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((NaturalNumber)that).isZero()) return false;
        return this.getPred().leq(((NaturalNumber)that).getPred());
    }
}

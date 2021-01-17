package numbers.integers.naturals.java;
import numbers.integers.naturals.NaturalNumber;

import algebra.*;
import order.*;

public final class JavaNatural extends NaturalNumber {

    private       int payload;
    private final int getPayload () { return payload; }

    public JavaNatural (final int payload) {
        if (0<=payload) this.payload = payload;
        else throw new
                IllegalArgumentException("Natural numbers are non-negative!");
    }

    public final NaturalNumber getPred () {
        return !isZero() ? new JavaNatural(getPayload()-1) : null;
    }

    public final boolean eq (final DiscreteOrder<NaturalNumber> that) {
        return (this.getPayload()==((JavaNatural)that).getPayload());
    }

    public final int hashCode() { return getPayload(); }

    public final AdditiveSemigroup<NaturalNumber> plus (
            final AdditiveSemigroup<NaturalNumber> that) {
        return this.plus(that, (AdditiveSemigroup<NaturalNumber>)
                (new JavaNatural(getPayload()-1)));
    }

    public final AdditiveGroup<NaturalNumber> minus (
            final AdditiveGroup<NaturalNumber> that) {
        return this.minus(that, (AdditiveGroup<NaturalNumber>)
                (new JavaNatural(getPayload()-1)));
    }

    public boolean leq (
            final PartialOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((JavaNatural)that).isZero())   return false;
        return this.getPred().leq(((JavaNatural)that).getPred());
    }
}

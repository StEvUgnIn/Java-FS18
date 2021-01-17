package numbers.rationals.integers.naturals.java;
import  numbers.rationals.integers.naturals.NaturalNumber;

import algebra.*;
import order.*;

import java.util.Objects;

public final class JavaNatural extends NaturalNumber {
 
    private       int payload;
    private       int getPayload () { return payload; }
    
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
        return this.plus(that, new JavaNatural(getPayload()+1));
    }

    public final boolean leq (PartialOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((NaturalNumber)that).isZero()) return false;
        return Objects.requireNonNull(
                this.getPred()).leq(((NaturalNumber)that).getPred()
        );
    }
}

package numbers.rationals.integers.naturals;
import  numbers.rationals.integers.naturals.java.JavaNatural;
import  numbers.rationals.integers.naturals.peano.*;

import algebra.*;
import order.*;

public abstract class NaturalNumber
    implements  CommutativeSemiring <NaturalNumber>,
                StrictLinearOrder   <NaturalNumber> {
        
    // bootstrapping the natural numbers with the neutral elements
    public static final AdditiveMonoid       <NaturalNumber> ZER = 
        new Zero();                         // new JavaNatural(0);
    public static final MultiplicativeMonoid <NaturalNumber> ONE = 
        new Succ((NaturalNumber)ZER);       // new JavaNatural(1);
                    
    public static final CommutativeSemiring  <NaturalNumber> TWO =
        ((CommutativeSemiring<NaturalNumber>)ONE).incr();

    public final AdditiveMonoid       <NaturalNumber> getZero () { return ZER; }
    public final MultiplicativeMonoid <NaturalNumber> getOne  () { return ONE; }

    public abstract boolean eq (final DiscreteOrder<NaturalNumber> that) ;

    // could be defined in the final subclasses
    public final boolean isZero () { return this.eq((NaturalNumber)getZero()); }
    public final boolean isOne  () { return this.eq((NaturalNumber)getOne()); }

    // not needed with pattern-matching (Java lacks it :-(
    public abstract NaturalNumber getPred () ;
                    
    public final boolean leq (final LinearOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((NaturalNumber)that).isZero()) return false;
        return this.getPred().leq(((NaturalNumber)that).getPred());
    }
                    
    public abstract AdditiveSemigroup<NaturalNumber> plus (
              final AdditiveSemigroup<NaturalNumber> that) ;

    // helper "plus", 'next' of type PeanoNatural or JavaNatural
    public final AdditiveSemigroup<NaturalNumber> plus (
        final AdditiveSemigroup<NaturalNumber> that, 
        final AdditiveSemigroup<NaturalNumber> next) {
        if (this.isZero())                  return that;
        if (((NaturalNumber)that).isZero()) return this;
        return next.plus(((NaturalNumber)that).getPred());
    }
    // adaptor "times"
    public final MultiplicativeSemigroup <NaturalNumber> times (
           final MultiplicativeSemigroup <NaturalNumber> that) {
           return (CommutativeSemiring<NaturalNumber>)
                    (((AdditiveMonoid <NaturalNumber>)this).times(
                    (NaturalNumber)that));
    }

    public final MultiplicativeSemigroup <NaturalNumber> doubled () {
        return this.times((MultiplicativeSemigroup<NaturalNumber>)TWO);
    }
    public final MultiplicativeMonoid    <NaturalNumber> squared () {
        return (MultiplicativeMonoid<NaturalNumber>)this.times((MultiplicativeSemigroup<NaturalNumber>)this);
    }

    public final NaturalNumber pow(final int n) {
        return (NaturalNumber)pow(new JavaNatural(n));
    }
    
    public abstract int hashCode () ;
                    
    public final int    toDecimal () { return hashCode(); }
    public final String toString  () { return Integer.toString(toDecimal()); }
}

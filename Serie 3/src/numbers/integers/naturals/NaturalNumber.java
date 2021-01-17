package numbers.integers.naturals;
import  numbers.integers.naturals.peano.*;

import algebra.*;
import order.*;

public abstract class NaturalNumber
         implements   AdditiveGroup<NaturalNumber>,
                      StrictLinearOrder<NaturalNumber> {

    /**
     * Basic values for natural numbers
     */
    public final static NaturalNumber ZER = new Zero();
    public final static NaturalNumber ONE = new Succ(ZER);
    public final static NaturalNumber TWO = new Succ(ONE);

    /**
     * m modulo n
     * where m = this and n = that
     * @param that n
     * @return
     */
    public final NaturalNumber modulo (
            final NaturalNumber that) {
        if (that.isZero()) throw new ArithmeticException();
        if (this.eq(that)) return getZero();
        if (this.le(that)) return this;
        final NaturalNumber diff = (NaturalNumber)this.minus(that);
        return diff.modulo(that);
    }

    /**
     * evaluate if value is equal to zero
     * @return true or false
     */
    public final boolean isZero () {
        return this.eq(getZero());
    }

    /**
     * return the predecessor of this natural number
     * @return the predecessor
     */
    public abstract NaturalNumber getPred();

    public abstract boolean eq (final DiscreteOrder<NaturalNumber> that);

    public final boolean leq (final LinearOrder<NaturalNumber> that) {
        if (this.isZero())                  return true;
        if (((NaturalNumber)that).isZero()) return false;
        return this.getPred().leq(((NaturalNumber)that).getPred());
    }

    public abstract boolean leq (final PartialOrder<NaturalNumber> that);

    public final NaturalNumber getZero () {
        return ZER;
    }

    /**
     * Returns the sum of that and next
     * @param that  first  operand
     * @param next  second operand
     * @return the sum of two operands
     */
    public final AdditiveSemigroup<NaturalNumber> plus (
            final AdditiveSemigroup<NaturalNumber> that,
            final AdditiveSemigroup<NaturalNumber> next) {
        if (this.isZero())                  return that;
        if (((NaturalNumber)that).isZero()) return this;
        return next.plus(((NaturalNumber)that).getPred());
    }

    /**
     * return the absolute substracted value of that and prev
     * @param that first  operand
     * @param prev second operand
     * @return the absolute value of that minus prev
     */
    public final AdditiveGroup<NaturalNumber> minus (final AdditiveGroup<NaturalNumber> that, final AdditiveGroup<NaturalNumber> prev) {
        return this.isZero() ?            that:
        ((NaturalNumber)that).isZero() ?  this:
        ((NaturalNumber)prev).minus(((NaturalNumber)prev).getPred(), that);
    }

    public abstract AdditiveSemigroup<NaturalNumber> plus (final AdditiveSemigroup<NaturalNumber> that);

    public abstract AdditiveGroup<NaturalNumber> minus (final AdditiveGroup<NaturalNumber> that);

    @Override
    public abstract int hashCode ();

    public final int    toDecimal () { return hashCode(); }

    @Override
    public final String toString () {
        return Integer.toString(hashCode());
    }
}

package numbers.integers.naturals.peano;

import numbers.integers.naturals.NaturalNumber;
import order.DiscreteOrder;


public final class Succ extends PeanoNatural {
 
    private NaturalNumber pred;
    public  final NaturalNumber getPred () { return pred; }
    
    public Succ (final NaturalNumber n) { pred = n; }
    
    public final boolean eq (final DiscreteOrder<NaturalNumber> that) {
        return (that instanceof Succ &&
                this.getPred().eq(((NaturalNumber)that).getPred()));
    }
    
    public final int hashCode () { return 1+getPred().hashCode(); }
}

package ex2;

import java.util.*;

public class Polynomial2 implements Operations<Polynomial2>, Cloneable {
    private Map<Integer, Term> terms;

    private Polynomial2() {
        this.terms = new TreeMap<>(Collections.reverseOrder());
    }

    public Polynomial2(int... values) {
        this();
        for (int i = values.length-1; i >= 0; i--) {
            terms.put(values.length-i-1, new Term(values[i], values.length-i-1));
        }
    }

    public Polynomial2(Map<Integer, Term>... terms) {
        this();
        Arrays.stream(terms).forEach(l -> this.terms.putAll(l));
    }

    public Polynomial2(Map<Integer, Term> terms) {
        this();
        this.terms.putAll(terms);
    }

    public Polynomial2 add(Polynomial2 p) {
        Iterator<Term> iterator = terms.values().iterator();
        while (iterator.hasNext()) {
            Term term = iterator.next();
            boolean anyFound = false;
            Iterator oIterator = p.terms.values().iterator();
            anyFound = Operations.isAnyFound(term, anyFound, oIterator);
            if (!anyFound) p.terms.put(term.getPower(), term);
        }
        return p;
    }

    public Polynomial2 multiply(Polynomial2 p) {
        Iterator<Term> iterator = terms.values().iterator();
        while (iterator.hasNext()) {
            Term term = iterator.next();
            Iterator oIterator = p.terms.values().iterator();
            while (oIterator.hasNext()) {
                Term oTerm = (Term)oIterator.next();
                oTerm.setValue(oTerm.getCoefficient() * term.getCoefficient(), term.getPower() + oTerm.getPower());
            }
        }
        return p;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polynomial2 that = (Polynomial2)o;

        return terms.equals(that.terms);
    }

    @Override
    public int hashCode () {
        return terms.hashCode();
    }

    @Override
    public String toString () {
        if (terms.size() > 0) {
            Iterator<Term> iter = terms.values().iterator();
            String result = "";
            while (iter.hasNext()) {
                Term term = iter.next();
                if (!result.isEmpty() && term.getCoefficient() > 0) result = String.format("%s + ", result);
                result += term;
            }
            if (result.isEmpty()) return "0";
            return result;
        }
        return super.toString();
    }

    @Override
    public Object clone () {
        return new Polynomial2(this.terms);
    }
}

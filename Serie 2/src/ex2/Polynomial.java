package ex2;

import java.util.*;

public class Polynomial implements Operations<Polynomial>, Cloneable {
    private LinkedList<Term> terms;

    private Polynomial() {
        this.terms = new LinkedList<>();
    }

    public Polynomial(int... values) {
        this();
        for (int i = values.length-1; i >= 0; i--) {
            terms.add(new Term(values[i], values.length-i-1));
        }
    }

    public Polynomial(List<Term>... terms) {
        this();
        Arrays.stream(terms).forEach(l -> this.terms.addAll(l));
    }

    public Polynomial(List<Term> terms) {
        this();
        this.terms.addAll(terms);
    }

    public Polynomial add(Polynomial p) {
        Iterator<Term> iterator = terms.iterator();
        while (iterator.hasNext()) {
            Term term = iterator.next();
            {
                boolean anyFound = false;
                {
                    Iterator oIterator = p.terms.iterator();
                    anyFound = Operations.isAnyFound(term, anyFound, oIterator);
                }
                if (!anyFound) p.terms.add(term);
            }
        }
        return p;
    }

    public Polynomial multiply(Polynomial p) {
        Iterator<Term> iterator = terms.iterator();
        while (iterator.hasNext()) {
            Term term = iterator.next();
            Iterator oIterator = p.terms.iterator();
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

        Polynomial that = (Polynomial)o;

        return terms.equals(that.terms);
    }

    @Override
    public int hashCode () {
        return terms.hashCode();
    }

    @Override
    public String toString () {
        if (terms.size() > 0) {
            Iterator<Term> iter = terms.descendingIterator();
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
        return new Polynomial(this.terms);
    }
}

interface Operations<T> {
    T add (T t);
    T multiply (T t);

    static boolean isAnyFound (Term term, boolean anyFound, Iterator<Term> oIterator) {
        while (oIterator.hasNext()) {
            Term oTerm = oIterator.next();
            anyFound |= term.getPower() == oTerm.getPower();
            if (term.getPower() == oTerm.getPower())
                oTerm.setValue(oTerm.getCoefficient() + term.getCoefficient(), oTerm.getPower());
        }
        return anyFound;
    }
}

class Term {
    private int coeff;
    private int pow;

    private static final char VAR = 'x';

    Term(int coefficient, int power) {
        setValue(coefficient, power);
    }

    int getCoefficient () {
        return coeff;
    }

    int getPower () {
        return pow;
    }

    void setValue(int coefficient, int power) {
        coeff = coefficient;
        pow = power;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term)o;

        if (getCoefficient() != term.coeff) return false;
        return pow == term.pow;
    }

    @Override
    public int hashCode () {
        int result = getCoefficient();
        result = 31 * result + getPower();
        return result;
    }

    @Override
    public String toString () {
        String result = "";
        if (coeff != 0) {
            if (coeff < 0) result = "- ";

            if (coeff != 1 && coeff != -1) result += Math.abs(coeff);

            if (pow != 1 && pow != 0) result = String.format("%s%c^%d", result, VAR, getPower());
            else if (pow == 1) result += VAR;
            else result += Math.abs(coeff);
        }
        return result;
    }
}
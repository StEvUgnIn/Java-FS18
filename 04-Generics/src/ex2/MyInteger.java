package ex2;

public class MyInteger extends Number implements Appendable<MyInteger> {
    public MyInteger(MyInteger integer) {
        this(integer.integer);
    }

    public MyInteger (int integer) {
        this.integer = integer;
    }

    private int integer;

    private MyInteger add(MyInteger integer) {
        return new MyInteger(this.integer + integer.integer);
    }

    @Override
    public MyInteger append (MyInteger integer) {
        return add(integer);
    }

    @Override
    public int intValue () {
        return integer;
    }

    @Override
    public long longValue () {
        return (long)integer;
    }

    @Override
    public float floatValue () {
        return (float)integer;
    }

    @Override
    public double doubleValue () {
        return (double)integer;
    }
}

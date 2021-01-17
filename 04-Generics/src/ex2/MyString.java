package ex2;

public class MyString implements Appendable<MyString>, CharSequence {
    public  MyString(char[] chars) {
        this.chars = chars;
    }

    public MyString(MyString string) {
        this(string.chars);
    }

    private char[] chars;

    @Override
    public MyString append (MyString string) {
        return new MyString(string);
    }

    @Override
    public int length () {
        return chars.length;
    }

    @Override
    public char charAt (int index) {
        if (index < length())
            throw new StringIndexOutOfBoundsException("start character must be inferior to length");
        return chars[index];
    }

    @Override
    public MyString subSequence (int start, int end) {
        if (end < start)
            throw new StringIndexOutOfBoundsException("end characted index must be inferior to start character index");

        char[] chars = new char[end - start];
        for (int i = start; i <= end && i <= length(); i++) chars[i - start] = this.chars[i];
        return new MyString(chars);
    }

    @Override
    public String toString () {
        return new String(chars);
    }
}

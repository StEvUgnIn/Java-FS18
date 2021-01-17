import numbers.integers.naturals.NaturalNumber;
import numbers.integers.naturals.peano.Succ;

public class Main {

    public static void main (String[] args) {
        NaturalNumber m = NaturalNumber.TWO; // 2
        NaturalNumber n = new Succ(m);       // 3
        System.out.println("m="+ m);
        System.out.println("n="+ n);
        System.out.println("n+m: " + n.plus(m));
        System.out.println("m+n: " + m.plus(n));
        System.out.println("n-m: " + m.minus(n));
        System.out.println("n-m: " + n.minus(m));
        try {
            System.out.println("modulo(0, 0): " + NaturalNumber.ZER.modulo(NaturalNumber.ZER));
            System.out.println("modulo(0, 1): " + NaturalNumber.ZER.modulo(NaturalNumber.ONE));
            System.out.println("modulo(1, 0): " + NaturalNumber.ONE.modulo(NaturalNumber.ZER));
        } catch (ArithmeticException ignored) {
        } catch (Exception e) {
            System.out.print("Unexcepted exception: ");
            e.printStackTrace();
        }
        System.out.println("modulo(1, 1): " + NaturalNumber.ONE.modulo(NaturalNumber.ONE));
        System.out.println("modulo(1, 2): " + NaturalNumber.ONE.modulo(NaturalNumber.TWO));
        System.out.println("modulo(2, 1): " + NaturalNumber.TWO.modulo(NaturalNumber.ONE));
        System.out.println("modulo(2, 2): " + NaturalNumber.TWO.modulo(NaturalNumber.TWO));
        System.out.println("modulo(m, n): " + m.modulo(n));
    }
}

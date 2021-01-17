package ex2;

public class Main {
    public static void main (String[] args) {
        Polynomial p1, p2;
        p1 = new Polynomial(5, 4, 3, 2, 1, 0);
        p2 = new Polynomial(1, 1, 1, 1, 1, 1);
        System.out.println("p(x) = " + p1.add(p2));


        p1 = new Polynomial(5, 4, 3, 2, 1, 0);
        p2 = new Polynomial(0, 0, 0, 0, 0, 0);
        System.out.println("p(x) = " + p1.multiply(p2).toString());
    }
}

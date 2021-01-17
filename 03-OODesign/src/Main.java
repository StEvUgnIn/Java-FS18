import numbers.rationals.integers.naturals.NaturalNumber;
import numbers.rationals.integers.naturals.peano.*;

public class Main {
	
	public static void main(String[] args){	
		NaturalNumber ZERO = new Zero();
		NaturalNumber ONE  = new Succ(ZERO);
		NaturalNumber TWO  = new Succ(ONE);
		NaturalNumber FOUR = new Succ(new Succ(TWO));
		
		System.out.println("==============================================================");
		System.out.printf("= \t\t\u2203x=4, y=2 \u2115 : | x ≤ y |%22b=\n", FOUR.leq(TWO));
		System.out.println("==============================================================");
		System.out.println("\n************************ Exercise 1: *************************");
		System.out.println("\t f(b,0) = 1");
		System.out.println("\t f(b,succ(0) = b");
		System.out.println("\t f(b,succ(succ(n)) = b.f(b,succ(n))");
		System.out.println("\n\t Definition:  \t pow \u2261 f ");
		System.out.println("\n expected:  256\t \t for example 4 pow 4 = " + FOUR.pow(FOUR));
		System.out.println("\n expected:  16\t \t for example 2 pow 4 = "  + TWO.pow(FOUR));
		System.out.println("\n expected:  16\t \t for example 2 pow 4 = "  + TWO.pow(4));
	}
}

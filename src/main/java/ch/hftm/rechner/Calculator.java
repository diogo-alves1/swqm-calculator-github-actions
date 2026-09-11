package ch.hftm.rechner;

public class Calculator {

	// Addiert zwei Zahlen und gibt das Resultat zurück.
	public double add(double a, double b) {
		return a + b;
	}

	// Subtrahiert die zweite Zahl von der ersten Zahl.
	public double subtract(double a, double b) {
		return a - b;
	}

	// Multipliziert zwei Zahlen miteinander.
	public double multiply(double a, double b) {
		return a * b;
	}

	// Dividiert die erste Zahl durch die zweite Zahl.
	public double divide(double a, double b) {
		// Eine Division durch null ist nicht erlaubt.
		if (b == 0) {
			throw new ArithmeticException("Division durch null ist nicht erlaubt.");
		}

		return a / b;
	}

}

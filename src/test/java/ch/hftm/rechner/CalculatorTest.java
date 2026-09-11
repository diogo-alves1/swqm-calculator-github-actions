package ch.hftm.rechner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		// Vor jedem Test wird ein neuer, unabhängiger Rechner erstellt.
		calculator = new Calculator();
	}

	@Test
	void addPositiveIntegers() {
		double result = calculator.add(5, 2);
		assertEquals(8, result, 0.001);
	}

	@Test
	void addDoubles() {
		double result = calculator.add(-5.24, 4.1);
		assertEquals(-1.14, result, 0.001);
	}

	@Test
	void subtractDecimalFromInteger() {
		double result = calculator.subtract(92, 1.2);
		assertEquals(90.8, result, 0.001);
	}

	@Test
	void multiplyDecimalWithNegativeInteger() {
		double result = calculator.multiply(2.5, -10);
		assertEquals(-25, result, 0.001);
	}

	@Test
	void divideIntegers() {
		double result = calculator.divide(20, 5);
		assertEquals(4, result, 0.001);
	}

	@Test
	void divideByZeroThrowsException() {
		// Der Test ist erfolgreich, wenn genau diese Exception ausgelöst wird.
		assertThrows(ArithmeticException.class, () -> calculator.divide(12, 0));
	}
}

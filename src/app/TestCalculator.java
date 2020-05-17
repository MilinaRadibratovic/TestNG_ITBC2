package app;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCalculator {
	protected static SoftAssert sa = new SoftAssert();
	protected static Calculator calc = new Calculator();
	protected static double[] addNumb = { 0.0, -10.01, -1.09, 0.0, 5.06, 9.99 };
	protected static double[] divNumb = { -3.3, -0.09, 4.02, 8.98347424, 9.9 };
	private static final double DELTA = 1e-9;

	@BeforeMethod
	public void returnToStartValue() {
		calc.setValue(0);
	}

	@Test // (priority=1)
	public void addingNum() {
		double expected = 0d;
		for (int i = 0; i < addNumb.length; i++) {
			calc.add(addNumb[i]);
			expected += addNumb[i];
			sa.assertEquals(calc.getValue(), expected);
		}
		sa.assertAll();
	}

	@Test
	public void divZeroWithNum() {
		for (int i = 0; i < divNumb.length; i++) {
			calc.div(divNumb[i]);
			sa.assertEquals(Math.abs(calc.getValue()), 0.00);
		}
		sa.assertAll();
	}

	@Test
	public void divNumWithNum() {
		double setNum = 9.99;
		for (int i = 0; i < divNumb.length; i++) {
			calc.setValue(setNum);
			calc.div(divNumb[i]);
			sa.assertEquals(calc.getValue(), setNum / divNumb[i], DELTA);
		}
		sa.assertAll();
	}

	@Test
	public void divNumWithZero() {
		double setNum = 9.99;
		calc.setValue(setNum);
		calc.div(0);
		Assert.assertEquals(calc.getValue(), Double.NaN, "Error message should be displayed.");
	}

	@Test
	public void divZeroWithZero() {
		calc.div(0);
		Assert.assertEquals(calc.getValue(), 0.0);
	}
}

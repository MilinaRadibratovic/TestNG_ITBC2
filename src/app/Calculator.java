package app;

/*
 * Calculator calc = new Calculator();
 * calc.add(5).sub(3).mul(2).div(3);
 * Syso(calc.getValue());
 * */
public class Calculator {
	private double value = 0;

	public Calculator add(double value) {
		this.value += value;
		return this;
	}

	public Calculator div(double value) {
		if (value != 0) {
			this.value /= value;
		}
		return this;
	}

	public double getValue() {
		return value;
	}

	public Calculator setValue(double value) {
		this.value = value;
		return this;
	}
}

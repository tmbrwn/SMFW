package oneyre.smfw;

/*
 * Quick and dirty mutable types for storing in-game variables
 */
public class Variable {
	public static class Integer {
		public int value;
		public Integer(int value) {
			this.value = value;
		}
	}
	public static class Double {
		public double value;
		public Double(double value) {
			this.value = value;
		}
	}
	public static class Boolean {
		public boolean value;
		public Boolean(boolean value) {
			this.value = value;
		}
	}
}

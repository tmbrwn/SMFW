package oneyre.smfw;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;

public class ValueTweaker {

	private static Map<String, Type> variables = new HashMap<>();
	private static Map<String, Variable.Integer> ints = new HashMap<>();
	private static Map<String, Variable.Double> doubles = new HashMap<>();
	private static Map<String, Variable.Boolean> bools = new HashMap<>();
	private static Map<String, Variable.Float> floats = new HashMap<>();
	
	private enum Type {
		INT, DOUBLE, BOOL, FLOAT;
	}
	
	public static Variable.Integer put(String var, int val) {
		variables.put(var, Type.INT);
		Variable.Integer i = new Variable.Integer(val);
		ints.put(var, i);
		return i;
	}
	
	public static Variable.Double put(String var, double val) {
		variables.put(var, Type.DOUBLE);
		Variable.Double d = new Variable.Double(val);
		doubles.put(var, d);
		return d;
	}
	
	public static Variable.Boolean put(String var, boolean val) {
		variables.put(var, Type.BOOL);
		Variable.Boolean b = new Variable.Boolean(val);
		bools.put(var, b);
		return b;
	}
	
	public static Variable.Float put(String var, float val) {
		variables.put(var, Type.FLOAT);
		Variable.Float f = new Variable.Float(val);
		floats.put(var, f);
		return f;
	}
	
	public static void update(String var, String val) throws CommandException {
		if(!variables.containsKey(var)) throw new WrongUsageException("commands.smfw.tweak.usage");
		switch(variables.get(var)) {
		case INT:
			ints.get(var).value = Integer.parseInt(val);
			break;
		case DOUBLE:
			doubles.get(var).value = Double.parseDouble(val);
			break;
		case BOOL:
			bools.get(var).value = Boolean.parseBoolean(val);
			break;
		case FLOAT:
			floats.get(var).value = Float.parseFloat(val);
		}
	}
}

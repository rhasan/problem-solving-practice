package refresh2016.cp.exercise.ch1;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Page12Ex_1_2_3_10_expression {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript"); // "cheat"
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine())
			System.out.println(engine.eval(sc.nextLine()));
	}
}

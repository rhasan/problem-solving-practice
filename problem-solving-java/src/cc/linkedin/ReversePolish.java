package cc.linkedin;

import sedgewick.fundamentals.Stack;

/**
 * http://www.careercup.com/question?id=5685440222855168
 * Evaluate the value of an expression given in Reverse Polish notation
 * @author Rakebul
 *
 */
public class ReversePolish {

	public static void main(String[] args) throws Exception {
		String expression = "5 1 2 + 4 * + 3 -";
		int val = ReversePolish.evaluate(expression);
		System.out.println("Result:" + val);
	}

	private static int evaluate(String expression) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		
		String[] tokens = expression.split(" ");
		
		for(String token:tokens) {
			System.out.println(token);
			if(isOperator(token)) {
				System.out.println("Operator, poping from the stack");
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = compute(op1,token,op2);
				stack.push(res);
			} else {
				System.out.println("Number, pushing in the stack");
				stack.push(Integer.valueOf(token));
			}
		}
		
		return stack.pop();
	}

	private static int compute(int op1, String operator, int op2) throws Exception {
		if(operator.equals("+")) return op1 + op2;
		else if(operator.equals("-")) return op1 - op2;
		else if(operator.equals("*")) return op1 * op2;
		else if(operator.equals("/")) return op1 / op2;
		else throw new Exception("Invalid operator");
	}

	private static boolean isOperator(String token) {
		if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
			return true;
		return false;
	}
	
}

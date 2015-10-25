package sedgewick.fundamentals;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


/**
 * 
 * @author rakebulh
 * Write a stack client Parentheses.java that reads in sequence of left and right parentheses, 
 * braces, and brackets from standard input and uses a stack to determine whether the sequence 
 * is properly balanced. For example, your program should print true for [()]{}{[()()]()} and false for [(]). 
 */
public class Parentheses {
	
	public static boolean isBalanced(String item) {
        Stack<Character> s = new Stack<Character>();

		for(int i = 0; i <item.length(); i++) {
        	char ch = item.charAt(i);
            //if start then push
            if(ch == '[' || ch == '(' || ch == '{') {
            	s.push(ch);
            }
            else { //otherwise pop and check the consistency 
            	if(s.isEmpty()) return false;
            	char top = s.pop();
            	if((ch == ')' && top != '(')
            			|| (ch == '}' && top != '{')   			
            			|| (ch == ']' && top != '[') ) {
            		return false;
            	}
            }
        }
        return s.isEmpty();
	}
	
	public static void main(String args[]) {
        String s = StdIn.readString();
        StdOut.println(isBalanced(s));

	}
}

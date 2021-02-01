package expression.evaluation;


import java.util.List;
import java.util.Stack;

public class PostFixCompute {
	
	
	private static Double applyOp(double o1, double o2, String op)
	{
		switch(op) {
			case "+":
				return o2 + o1;
			case "-":
				return o2 - o1;
			case "/":
				return o2 / o1;
			case "*":
				return o2 * o1;
			default:
				return 0.0;
		}
	}
	
	public static double computePostFix(String postfix)
	{
		Stack<String> stck = new Stack<>();
		int i = 0;
		while(i < postfix.length()-1)
		{
			
			String charAtI = Character.toString(postfix.charAt(i));
			if(charAtI.equals(" "))
			{
				i++;
				continue;
			}
			if(!InfixToPostfix.isOperator(charAtI))
			{
				List<String> s = InfixToPostfix.parseDDouble(postfix, i);
				String operand = s.get(0);
				i = Integer.parseInt(s.get(1));
				stck.push(operand);
				continue;
			}
			else
			{
				double o1 = Double.parseDouble(stck.pop());
				double o2 = Double.parseDouble(stck.pop());
				stck.push(Double.toString(applyOp(o1, o2, charAtI)));
			}
			i++;
		}
		return Double.parseDouble(stck.pop());
	}

}

package expression.evaluation;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
	
	
	
	
	/** 
	 * Parses the first found double in string d starting from index i
	 * @param d which is the string
	 * @param i the starting index
	 * @return returns a list having the first index as the first double found and its index i
	 */
	public static List<String> parseDDouble(String d, int i)
	{
		StringBuilder s = new StringBuilder("");
		while(i<d.length())
		{
			if(Character.isDigit(d.charAt(i)) || d.charAt(i) == '.')
			{
				s.append(d.charAt(i));
			}
			else break;
			i++;
		}
		String tmp = new String(s);
		return Arrays.asList(tmp, Integer.toString(i));
	}
	
	
	static int prec(String c) 
	{ 
	    if(c.equals("*") || c.equals("/")) 
	    return 2; 
	    else if(c.equals("+") || c.equals("-")) 
	    return 1; 
	    else
	    return -1; 
	} 
	
	
	/**
	 * checks if the string is an operator
	 * @param o String
	 * @return true if o is an operator, false otherwise
	 */
	static boolean isOperator(String o)
	{
		return o.equals("/") || o.equals("*") || o.equals("+") || o.equals("-");
	}
	
	
	
	
	
	static boolean isParenthesis(String s)
	{
		return s.equals("(") || s.equals(")");
	}
	
	static boolean isLeftParenthesis(String s)
	{
		return s.equals("(");
	}
	
	static boolean isRightParenthesis(String s)
	{
		return s.equals(")");
	}
	
	
	
	
	
	public static String infixToPostfix(String infix) {
		StringBuilder str = new StringBuilder("");
		
		
		infix = infix.replaceAll("\\s", "");
		
		Stack<String> stck = new Stack<>();
		stck.push("");
		int i = 0;
		while(i<infix.length())
		{
			List<String> doubIndex = parseDDouble(infix, i);
			
			String doub = doubIndex.get(0);
			
			String charAtI = Character.toString(infix.charAt(i));
			
			if(!isOperator(charAtI) && !isParenthesis(charAtI)) 
			{
				i = Integer.parseInt(doubIndex.get(1));
				i--;
				str.append(doub + " ");
			}
			else if(!isParenthesis(charAtI))
			{
				String old = stck.peek();
				
				if(old.isBlank() || old.equals("(") || prec(charAtI) > prec(old))
				{
					stck.push(charAtI);
				}
				else
				{
					while(prec(stck.peek()) >= prec(charAtI) && !isParenthesis(stck.peek()) && !stck.peek().equals(""))
					{
						str.append(stck.pop() + " ");
					}
					stck.push(charAtI);
				}
			}
			else if(isLeftParenthesis(charAtI))
			{
				stck.push(charAtI);
			}
			else if(isRightParenthesis(charAtI))
			{
				while(!stck.peek().equals("("))
				{
					str.append(stck.pop() + " ");
				}
				stck.pop();
			}
			i++;
		}
		
		while(!stck.peek().equals(""))
		{
			str.append(stck.pop() + " ");
		}
		
		return new String(str);
	}
	
}
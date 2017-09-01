package com.cleartax;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;

import utils.JsonParserForEquation;
import utils.OperationUtil;

public class EquationSimplifier {

	String getParsedEquation(String filePath) throws Exception {
		JsonNode node = JsonParserForEquation.getJsonNodeFromFilePath(filePath);

		return getSingleLineEquation(node);
	}

	private String getSingleLineEquation(JsonNode node) throws Exception {
		if (node == null)
			return "";
		String parsedEquation = "";

		JsonNode lhs = node.get("lhs");
		if (!lhs.isValueNode()) {
			parsedEquation += getSingleLineEquation(lhs);
		} else {
			parsedEquation += lhs.asText();
		}
		parsedEquation += " " + OperationUtil.getCorrespondingOpertion(node.get("op").asText()) + " ";

		JsonNode rhs = node.get("rhs");
		if (!rhs.isValueNode()) {
			parsedEquation += getSingleLineEquation(rhs);
		} else {
			parsedEquation += rhs.asText();
		}
		if (!node.get("op").asText().equals("equal"))
			parsedEquation = "(" + parsedEquation + ")";
		return parsedEquation;
	}

	public static String getSimplifiedEquation(String equation) {

		equation = equation.replace(" ", "");
		String[] strAr = equation.split("=");
		String lhs = strAr[0], rhs = strAr[1];

		return getRHS(lhs, rhs);
	}

	public static boolean isInteger(String s) {
		return isInteger(s, 10);
	}

	public static boolean isInteger(String s, int radix) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}


	private static String calculate(String left, String op, String right) {
		if (op.equals("+")) {
			return Integer.toString(Integer.parseInt(left) + Integer.parseInt(right));
		} else if (op.equals("-")) {
			return Integer.toString(Integer.parseInt(left) - Integer.parseInt(right));
		} else if (op.equals("*")) {
			return Integer.toString(Integer.parseInt(left) * Integer.parseInt(right));
		} else if (op.equals("/")) {
			return Integer.toString(Integer.parseInt(left) / Integer.parseInt(right));
		}
		return null;
	}

	public static String getRHS(String lhs, String rhs) {
		if (lhs.equals("x"))
			return lhs + "=" + rhs;

		String regex = "[-+*/]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(lhs);
		if (matcher.find()) {
			String left = lhs.substring(1, matcher.start());
			String right = lhs.substring(matcher.end(), lhs.length() - 1);
			String op = lhs.substring(matcher.start(), matcher.end());
			if (right.contains("x")) {
				rhs = "(" + rhs + OperationUtil.reverseMap.get(op) + left + ")";
				lhs = right;
			} else {
				rhs = "(" + rhs + OperationUtil.reverseMap.get(op) + right + ")";
				lhs = left;
			}
		}
		return getRHS(lhs, rhs);

	}
	public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Integer.parseInt(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
 

	public static void main(String[] args) throws Exception {
		EquationSimplifier equationSimplifier = new EquationSimplifier();
		String eq = equationSimplifier.getParsedEquation(
				"/Users/nitinmaheshwari/Documents/workspace/EquationEvaluator/src/main/resources/TestJson.text");
		System.out.println(eq);
		String seq =getSimplifiedEquation(eq);
		System.out.println(seq);
		System.out.println(evaluate(seq.split("=")[1].replaceAll(" ", "")));
	}
}

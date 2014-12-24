package com.test;

public class RemoveRedundentBracket {

	public static void main(String[] args) {

        System.out.println(removeParenthesis(new StringBuilder("((a*b)+c*(e+f))")));
        System.out.println(removeParenthesis(new StringBuilder("(a+(b*c))*(d*(f*j))")));
        System.out.println(removeParenthesis(new StringBuilder("(a+(b))")));
        System.out.println(removeParenthesis(new StringBuilder("((a+b)+((c+d)))")));
    }

    public static String removeParenthesis(StringBuilder sb) {
        if (removeParenthesis(null, sb, 0)) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static boolean removeParenthesis(Integer leftPrecedence, StringBuilder sb, int start) {
        Integer lastPrecedence = null;
        Integer minPrecedence = null;
        while (start < sb.length()) {
            if (sb.charAt(start) == '(') {
                if (removeParenthesis(lastPrecedence, sb, start + 1)) {
                    sb.deleteCharAt(start);
                } else {
                    int count = 0;
                    do {
                        if (sb.charAt(start) == '(') {
                            count++;
                        } else if (sb.charAt(start) == ')') {
                            count--;
                        }
                        start++;
                    } while (start < sb.length() && count != 0);
                    continue;
                }
            } else if (sb.charAt(start) == ')') {
                if(minPrecedence == null) {
                    sb.deleteCharAt(start);
                    return true;
                }
                Integer rightPrecedence = start == sb.length() - 1 || sb.charAt(start + 1) == ')' ? null
                        : getPrecedence(sb.charAt(start + 1));
                if ((leftPrecedence != null && minPrecedence < leftPrecedence)
                        || (rightPrecedence != null && minPrecedence < rightPrecedence)) {
                    return false;
                } else {
                    sb.deleteCharAt(start);
                    return true;
                }
            } else if (sb.charAt(start) < 'a' || sb.charAt(start) > 'z') {
                lastPrecedence = getPrecedence(sb.charAt(start));
                if (minPrecedence == null || minPrecedence > lastPrecedence) {
                    minPrecedence = lastPrecedence;
                }
            }
            start++;
        }
        return false;
    }

    public static int getPrecedence(char operator) {
        switch (operator) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        }
        throw new IllegalArgumentException(">>" + operator + "<<");
    }
}

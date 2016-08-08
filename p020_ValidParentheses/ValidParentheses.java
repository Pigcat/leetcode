package p020_ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
	
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
        	char t = s.charAt(i);
        	if(stack.isEmpty())
        	{
        		stack.push(t);
        	}
        	else
        	{
        		char u = stack.pop();
        		if( (u == '(' && t == ')') || (u == '[' && t == ']') || (u == '{' && t == '}') )
        			continue;
        		if( t == '(' || t == '[' || t == '{')
        		{
        			stack.push(u);
        			stack.push(t);
        		}
        		else
        			return false;
        	}
        }
        if(stack.isEmpty())
        	return true;
        else
        	return false;
    }
	
	// only "()[]{}" is valid
	/*
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0)
        	return false;
        for(int i = 0; i < len; i = i + 2)
        {
        	if( !((s.charAt(i) == '(' && s.charAt(i+1) == ')') ||
        			(s.charAt(i) == '[' && s.charAt(i+1) == ']') ||
        			(s.charAt(i) == '{' && s.charAt(i+1) == '}')))
        		return false;
        }
        return true;
    }
    */
	
	// "([)]" is valid
	/* 
    public boolean isValid(String s) {
        int[] bracs = new int[3];
        for(int i = 0; i < s.length(); i++)
        {
        	switch(s.charAt(i))
        	{
	        	case '(': bracs[0]++; break;
	        	case '{': bracs[1]++; break;
	        	case '[': bracs[2]++; break;
	        	case ')': bracs[0]--; if(bracs[0] < 0) return false; break;
	        	case '}': bracs[1]--; if(bracs[1] < 0) return false; break;
	        	case ']': bracs[2]--; if(bracs[2] < 0) return false; break;
        	}
        }
        for(int i = 0; i < 3; i++)
        	if(bracs[i] > 0)
        		return false;
        return true;
    }
    */
}

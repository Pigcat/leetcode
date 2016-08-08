package p022_GenerateParentheses;

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
	/*
	public static void main(String[] args)
	{
		new GenerateParentheses().generateParenthesis(3);
	}
	*/
	
    public List<String> generateParenthesis(int n) {
        if(n==0)
        	return new ArrayList<>();
    	List<String>[] ans = new List[n+1];
    	ans[0] = new ArrayList<>();
    	ans[0].add("");
    	ans[1] = new ArrayList<>();
    	ans[1].add("()");
    	for(int i = 2; i <= n; i++)
    	{
    		//notice: must generate a ArrayList!
    		ans[i] = new ArrayList<>();
    		for(int j = 2; j <= 2*i; j = j + 2)
    		{
    			List<String> pre = ans[(j-2)/2];
    			List<String> suf = ans[(2*i-j)/2];
    			for(int k = 0; k < pre.size(); k++)
    				for(int l = 0; l < suf.size(); l++)
    					ans[i].add("("+pre.get(k)+")"+suf.get(l));
    		}
    	}
        return ans[n];
    }
}

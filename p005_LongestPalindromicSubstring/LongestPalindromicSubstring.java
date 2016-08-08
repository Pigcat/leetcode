package p005_LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    
	public static void main(String args[])
	{
		LongestPalindromicSubstring test = 
				new LongestPalindromicSubstring();
		String s = "abcdcbe";
		String result = test.longestPalindrome(s);
		System.out.println(result);
	}
	
	// expand around center
	/*
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i++)
		{
			int len1 = expandAroundCenter(s,i,i);
			int len2 = expandAroundCenter(s,i,i+1);
			int len = Math.max(len1, len2);
			if(len > end - start)
			{
				start = i - (len-1)/2;
				end = i + len/2;
			}
		}
		return s.substring(start, end+1);
	}
	private int expandAroundCenter(String s, int left, int right)
	{
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}
		return right-left-1;
	}
	*/

	// dynamic programming
	/*
	public String longestPalindrome(String s) {
		char[] cstr = s.toCharArray();
		
		// special case: 1or2 character(s)
		if(cstr.length == 1)
			return s;
		if(cstr.length == 2 && cstr[0] == cstr[1])
			if(cstr[0] == cstr[1])
				return s;
			else
				return s.substring(0, 1);
		
		// length longer than 3
		boolean[][] p = new boolean[cstr.length][cstr.length];
		int start = 0, end = 0;
		for(int i = 0; i < cstr.length; i++)
			p[i][i] = true;
		
		for(int i = 0; i < cstr.length - 1; i++)
			if(cstr[i] == cstr[i+1])
			{
				p[i][i+1] = true;
				// maybe:only palindromic of length 2
				start = i;
				end = i+1;
			}
		for(int tLength = 3; tLength <= cstr.length; tLength++)
		{
			for(int i = 0; i + tLength - 1 <= cstr.length - 1; i++)
			{
				if(p[i+1][i+tLength-2] == true && cstr[i] == cstr[i+tLength-1])
				{
					p[i][i+tLength-1] = true;
					start = i;
					end = i+tLength-1;
				}
			}
		}
		return s.substring(start, end+1);
	}
	*/
	
	// longest common substring , but time limit exceeded
	public String longestPalindrome(String s) {
		String rs = new StringBuffer(s).reverse().toString();
		s = " " + s;
		rs = " " + rs;
		int len = s.length() - 1;
		int maxLen = 0;
		int lastLoc = 0;
		int[][] p = new int[len+1][len+1];
		for(int i = 1; i <= len; i++)
			for(int j = 1; j <= len; j++)
			{
				if(s.charAt(i) == rs.charAt(j))
				{
					p[i][j] = p[i-1][j-1] + 1;
					if(p[i][j] > maxLen && correctInd(len,i,j,p[i][j]))
					{
						maxLen = p[i][j];
						lastLoc = i;
					}
				}
				else
				{
					p[i][j] = 0;
				}
			}
		return s.substring(lastLoc-maxLen+1, lastLoc+1);
	}
	
	private boolean correctInd(int sLen, int i , int j, int subLen)
	{
		if( i - subLen == sLen - j)
			return true;
		else
			return false;
	}
	
	// brute force
	/* 
	public String longestPalindrome(String s) {
        char[] cstr = s.toCharArray();
        for(int sLength = cstr.length; sLength >= 2; sLength--)
        	for(int i = 0; i+sLength <= cstr.length;i++)
        		if(judge(cstr,i,i+sLength-1))
        		{
        			return s.substring(i, i+sLength);
        		}
        return s.substring(0,1);
    }
    
    boolean judge(char[] cstr, int i, int j)
    {
    	while( i <= j )
    	{
    		if(cstr[i] != cstr[j])
    			return false;
    		i++;
    		j--;
    	}
    	return true;
    }
    */
}

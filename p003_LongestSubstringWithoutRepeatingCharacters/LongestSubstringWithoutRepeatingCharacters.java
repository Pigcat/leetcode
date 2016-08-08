package p003_LongestSubstringWithoutRepeatingCharacters;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String args[])
	{
		String s = "abba";
		LongestSubstringWithoutRepeatingCharacters test =
				new LongestSubstringWithoutRepeatingCharacters();
		int length = test.lengthOfLongestSubstring(s);
		System.out.println(length);
		
	}
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int j = 0, i = 0; j < n; j++)
		{
			if(map.containsKey(s.charAt(j)))
			{
				i = Math.max(i, map.get(s.charAt(j))+1);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j), j);
		}
		return ans;
	}
	
	/*
	public int lengthOfLongestSubstring(String s) {
		char[] cstr = (" "+s).toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		int start = 1, end = 1;
		int max = 0, tLength = 0;
		for(; end < cstr.length; end++)
		{
			//attention: start need change only when character repeat and "start" is lower
			if(map.containsKey(cstr[end]) && start <= map.get(cstr[end]))
				start = map.get(cstr[end]) + 1;
			map.put(cstr[end], end);
			tLength = end - start + 1;
			if(tLength > max)
				max = tLength;
		}
		return max;
	}
	*/
	
	// string just include "ab...z"
	/*
    public int lengthOfLongestSubstring(String s) {
    	char[] cstr = (" "+s).toCharArray();
    	int[] ind = new int[26];
    	int start = 1, end = 1;
    	int max = 0, tLength = 0;
    	for(;end < cstr.length;end++)
    	{
    		if(indexOf(cstr[end]) == -1)
    		{
    			start = end + 1;
    			continue;
    		}
    		if(ind[indexOf(cstr[end])] != 0 && start <= ind[indexOf(cstr[end])])
    			start = ind[indexOf(cstr[end])] + 1;
    		ind[indexOf(cstr[end])] = end;
    		tLength = end - start + 1;
    		if(tLength > max)
    			max = tLength;
    	}
    	return max;
    }
    */
	
	
    int indexOf(char c)
    {
    	if (c-'a' >= 0 && c-'a' <= 25)
    		return c-'a';
    	else
    		return -1;
    }
}

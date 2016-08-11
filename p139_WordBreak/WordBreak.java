package p139_WordBreak;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] ans = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
        	for(int j = i; j > 0; j--)
        	{
        		if(ans[j-1] == true && wordDict.contains(s.substring(j,i+1)))
        		{
        			ans[i] = true;
        			break;
        		}
        	}
        	if(ans[i] == false && wordDict.contains(s.substring(0,i+1)))
        		ans[i] = true;
        }
        return ans[s.length()-1];
    }
}

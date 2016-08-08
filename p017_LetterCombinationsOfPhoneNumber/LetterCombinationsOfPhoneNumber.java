package p017_LetterCombinationsOfPhoneNumber;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsOfPhoneNumber {
	
	String[] letters = new String[10];
	{
		letters[0] = "_";
		//letters[1] = "";
		letters[2] = "abc";
		letters[3] = "def";
		letters[4] = "ghi";
		letters[5] = "jkl";
		letters[6] = "mno";
		letters[7] = "pqrs";
		letters[8] = "tuv";
		letters[9] = "wxyz";
	}
	
	
    public List<String> letterCombinations(String digits) {
    	List<String> ans = new ArrayList<>();
    	int len = digits.length();
    	
    	if( len == 0 )
    		return ans;
    	for(int i = 0; i < len; i++)
    		if(digits.charAt(i) == '1')
    			return ans;
    	
    	comb(ans,digits,"",0);
    	return ans;
    }
    
    void comb(List<String> ans, String digits, String prefix, int loc)
    {
    	int num = digits.charAt(loc) - '0';
    	for(int i = 0; i < letters[num].length(); i++)
    	{
    		String tPrefix = prefix + letters[num].charAt(i);
    		if(loc == digits.length() - 1)
    			ans.add(tPrefix);
    		else
    			comb(ans, digits, tPrefix, loc+1);
    	}
    }
}

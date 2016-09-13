package p038_CountAndSay;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        int count = 0;
        StringBuilder preAns;
        for(int i = 1; i < n; i++)
        {
        	preAns = ans;
        	ans = new StringBuilder();
        	for(int j = 0; j < preAns.length(); j++)
        	{
        		count++;
        		if( j+1 == preAns.length() || preAns.charAt(j) != preAns.charAt(j+1))
        		{
        			ans.append(Integer.toString(count));
        			ans.append(preAns.charAt(j));
        			count = 0;
        		}
        	}
        }
        return ans.toString();      
    }
}

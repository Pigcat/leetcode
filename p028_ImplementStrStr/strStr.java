package p028_ImplementStrStr;

public class strStr {
    public int strStr(String haystack, String needle) {
    	if(haystack == null || needle == null )
    		return -1;
    	if(needle.length() == 0)
    		return 0;
    	if(haystack.length() < needle.length())
    		return -1;
    	
        int[] next = getNext(needle);
        int h = 0, n = 0;
        while( h < haystack.length() && n < needle.length() )
        {
        	if( n < 0 || haystack.charAt(h) == needle.charAt(n))
        	{
        		h++;
        		n++;
        	}
        	else
        	{
        		n = next[n];
        	}
        }
        if( n == needle.length() )
        	return h - n;
        else
        	return -1;
    }
    
    private int[] getNext(String needle)
    {
    	int[] next = new int[needle.length()];
    	next[0] = -1;
    	int k = -1;
    	for(int i = 1; i < next.length; i++)
    	{
    		while(k >= 0 && needle.charAt(k) != needle.charAt(i-1))
    			k = next[k];
    		k++;
    		if(needle.charAt(i) == needle.charAt(k))
    			next[i] = next[k];
    		else
    			next[i] = k;
    	}
    	return next;
    }
}

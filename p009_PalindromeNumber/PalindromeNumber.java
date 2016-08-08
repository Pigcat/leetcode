package p009_PalindromeNumber;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	// negative is not PalindromeNumber
    	if( x < 0 )
    		return false;
        int len = lengthOfNum(x);
        if(len == 1)
        	return true;
        int high = 1, low = 1;
        for(int i = len; i > 1; i--)
        	high *= 10;
        for(; high > low; high /= 10, low *= 10)
        {
        	if(numAt(x, high) != numAt(x, low))
        		return false;
        }
        return true;
    }
    
    int lengthOfNum(int num)
    {
    	int len = 1;
    	while( num >= 10)
    	{
    		num /= 10;
    		len++;
    	}
    	return len;
    }
    
    int numAt(int num, int loc)
    {
    	num = num / loc;
    	return num % 10;
    }
}

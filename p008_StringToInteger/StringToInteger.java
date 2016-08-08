package p008_StringToInteger;

public class StringToInteger {
    public int myAtoi(String str) {
    	//discards whitespace
        str = str.trim();
        
        //length == 0
        if(str.length() == 0)
        	return 0;
        
        //length == 1
        if(str.length() == 1)
        {
        	if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
        		return str.charAt(0) - '0';
        	else
        		return 0;
        }
        
        long ans = 0;
        boolean neg = false;
        int i;
        /*
         * length >= 2,  an optional initial plus or minus sign
         * followed by as many numerical digits as possible,
         * otherwise return 0 
         */
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
        	i = 0;
        else if(str.charAt(0) == '+' && str.charAt(1) >= '0' && str.charAt(1) <= '9')
        	i = 1;
        else if(str.charAt(0) == '-' && str.charAt(1) >= '0' && str.charAt(1) <= '9')
        {
        	i = 1;
        	neg = true;
        }
        else
        	return 0;
        
        //caculate ans
        for(; i < str.length(); i++)
        {
        	if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
        	{
        		ans = ans * 10 + str.charAt(i) - '0';
        		// consider overflow
        		if( ans > Integer.MAX_VALUE || -ans < Integer.MIN_VALUE)
        			break;
        	}
        	else
        		break;
        }
        if(neg)
        	ans = -ans;
        
        //consider overflow
        if(ans > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(ans < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        else
        	return (int)ans;
    }
}

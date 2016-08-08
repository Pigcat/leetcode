package p007_ReverseInteger;

public class ReverseInteger {
    public int reverse(int x) {
    	long tm = x;
        tm = Math.abs(tm);
        long ans = 0, t;
        while( tm != 0 )
        {
        	t = tm % 10;
        	ans = ans * 10 + t;
        	tm = tm / 10;
        }
        if( ans >= Integer.MAX_VALUE)
        	return 0;
        if( x < 0 )
        	ans = -ans;
        return (int)ans;
    }
}

package p066_PlusOne;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	digits[digits.length-1]++;
    	for(int i = digits.length-2; i >= 0 && digits[i+1] == 10; i--)
    	{
    		digits[i+1] = 0;
    		digits[i]++;
    	}
    	if(digits[0] == 10)
    	{
    		digits[0] = 0;
    		int[] tDigits = new int[digits.length+1];
    		tDigits[0] = 1;
    		for(int i = 1; i < tDigits.length; i++)
    			tDigits[i] = digits[i-1];
    		digits = tDigits;
    	}
    	return digits;
    }
}

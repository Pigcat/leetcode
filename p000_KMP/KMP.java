package p000_KMP;

public class KMP {
	public static void main(String[] args)
	{
		String str = "eeeeabcee";
		String pat = "abc";
		int[] next = getNext(pat);
		//for(int i = 0; i < pat.length(); i++)
		//	System.out.println(next[i]);
		int index = kmpSearch(str, pat, next);
		System.out.println(index);
	}
	
	static int[] getNext(String pat)
	{
		int[] next = new int[pat.length()];
		next[0] = -1;
		int k = -1;
		for(int i = 1; i < pat.length(); i++)
		{
			while(k >= 0 && pat.charAt(i-1) != pat.charAt(k))
				k = next[k];
			k++;
			if(pat.charAt(i) == pat.charAt(k))
				next[i] = next[k];
			else
				next[i] = k;
		}
		return next;
	}
	
	static int kmpSearch(String str, String pat, int[] next)
	{
		int strLen = str.length();
		int patLen = pat.length();
		if(strLen < patLen)
			return -1;
		int i = 0, j = 0;
		while(i < strLen && j < patLen)
		{
			if(j == -1 || str.charAt(i) == pat.charAt(j))
			{
				i++;
				j++;
			}
			else
				j = next[j];
		}
		if( j >= patLen )
			return i - patLen ;
		else
			return -1;
	}
}

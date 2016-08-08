package p006_ZigZagConversion;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1)
        	return s;
        StringBuffer[] strBf = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
        	strBf[i] = new StringBuffer();
        for(int i = 0; i < s.length(); i++)
        {
        	int obj = i % (2*numRows-2);
        	if(obj > numRows-1)
        		obj = (2*numRows - 2) - obj;
        	strBf[obj].append(s.charAt(i));
        }
        for(int i = 1; i < numRows; i++)
        	strBf[0].append(strBf[i]);
        return strBf[0].toString();
    }
}

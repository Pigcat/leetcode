package p058_LengthOfLastWord;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
        	if(s.charAt(i) != ' ')
        		ans++;
        	else
        		break;
        }
        return ans;
    }
}

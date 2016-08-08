package p096_UniqueBinarySearchTrees;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
    	if(n == 0)
    		return 0;
        int[] results = new int[n+1];
        results[0] = 1;
        results[1] = 1;
        for(int i = 2; i <= n; i++)
        {
        	for(int j = 1; j <= i; j++)
        		results[i] += results[j-1] * results[i-j];
        }
        return results[n];
    }
}

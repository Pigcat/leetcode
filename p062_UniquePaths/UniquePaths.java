package p062_UniquePaths;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	int[][] pathNums = new int[m+1][n+1];
    	for(int i = 1; i <= m; i++)
    		pathNums[i][1] = 1;
    	for(int i = 1; i <= n; i++)
    		pathNums[1][i] = 1;
    	for(int i = 2; i <= m; i++)
    		for( int j = 2; j <= n; j++)
    			pathNums[i][j] = pathNums[i-1][j] + pathNums[i][j-1];
    	return pathNums[m][n];
    	
    	
    	/*
        if(m == 1 || n == 1)
        	return 1;
        return uniquePaths(m-1,n) + uniquePaths(m, n-1);
        */
    }
}

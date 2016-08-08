package p063_UniquePathsII;

public class UniquePathsII {
	public static void main(String args[])
	{
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		UniquePathsII test = new UniquePathsII();
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
	}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hight = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] pathNums = new int[hight][width];

        int i;
        for(i = hight-1; i >= 0 ; i--)
        {
        	if(obstacleGrid[i][width-1] == 0)
        		pathNums[i][width-1] = 1;
        	else
        		break;
        }
        for( ; i >= 0 ; i--)
        	pathNums[i][width-1] = 0;
        for(i = width-1; i >= 0; i--)
        {
        	if(obstacleGrid[hight-1][i] == 0)
        		pathNums[hight-1][i] = 1;
        	else
        		break;
        }
        for( ; i >= 0; i--)
        	pathNums[hight-1][i] = 0;
        
        for(int j = hight - 2; j >= 0; j--)
        	for(int k = width - 2; k >= 0; k--)
        	{
        		if(obstacleGrid[j][k] == 1)
        			pathNums[j][k] = 0;
        		else
        			pathNums[j][k] = pathNums[j+1][k] + pathNums[j][k+1];
        	}
        
        return pathNums[0][0];
    }
}

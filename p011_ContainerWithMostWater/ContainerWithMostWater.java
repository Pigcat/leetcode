package p011_ContainerWithMostWater;

public class ContainerWithMostWater {
	public static void main(String args[])
	{
		ContainerWithMostWater test = new ContainerWithMostWater();
		int[] height = new int[]{3,4,1,1,1,1,1,1,1,1,1,2};
		System.out.println(test.maxArea(height));
	}
	
    public int maxArea(int[] height) {
    	int i = 0, j = height.length - 1;
    	int ans = 0;
    	while( i < j )
    	{
    		ans = Math.max(ans, Math.min(height[i], height[j])*(j-i));
    		if( height[i] < height[j] )
    			i++;
    		else
    			j--;
    	}
    	return ans;
    }
}

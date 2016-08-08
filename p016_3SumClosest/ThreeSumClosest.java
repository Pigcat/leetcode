package p016_3SumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String args[])
	{
		int[] nums = new int[]{-1,2,1,-4};
		int target = 1;
		ThreeSumClosest test = new ThreeSumClosest();
		System.out.println(test.threeSumClosest(nums, target));
		
	}
	
    public int threeSumClosest(int[] nums, int target) {
        int dist = 999999999;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++)
        {
        	int pTarget = target - nums[i];
        	int p = i+1, q = nums.length-1;
        	while(p < q)
        	{
        		int tDist = pTarget - nums[p] - nums[q];
        		if(tDist == 0)
        			return target;
        		else if(tDist > 0)
        		{
        			if(tDist < Math.abs(dist))
        				dist = tDist;
        			p++;
        			while(p < q && nums[p] == nums[p-1])
        				p++;
        		}
        		else
        		{
        			if(-tDist < Math.abs(dist))
        				dist = tDist;
        			q--;
        			while(p < q && nums[q] == nums[q+1])
        				q--;
        		}
        	}
        	while(i < nums.length - 2 && nums[i] == nums[i+1])
        		i++;
        }
        return target - dist;
    }
}

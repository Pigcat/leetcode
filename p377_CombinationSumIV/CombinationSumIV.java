package p377_CombinationSumIV;

import java.util.Arrays;

public class CombinationSumIV {
	public static void main(String args[])
	{
		int[] nums = {3,1,2,4};
		int target = 4;
		CombinationSumIV test = new CombinationSumIV();
		System.out.println(test.combinationSum4(nums, target));
	}
	
    public int combinationSum4(int[] nums, int target) {
    	Arrays.sort(nums);
    	int[] res = new int[target+1];
    	for(int i = 1; i <= target; i++)
    	{
    		for(int j = 0; j < nums.length; j++)
    		{
    			if(nums[j] > i)
    				break;
    			else if(nums[j] == i)
    				res[i]++;
    			else
    				res[i] += res[i-nums[j]];
    		}
    	}
    	return res[target];
    	/*
    	if(target == 0)
    		return 1;
    	int ans = 0;
    	for(int i = 0; i < nums.length && target > 0; i++)
    	{
    		ans += combinationSum4(nums, target-nums[i]);
    	}
    	return ans;
    	*/
    }
}

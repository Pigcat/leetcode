package p152_MaximumProductSubarray;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	if(nums.length == 1)
    		return nums[0];
    	int max = nums[0], min = nums[0], result = nums[0];
    	for(int i = 1; i < nums.length; i++)
    	{
    		int t = max;
    		max = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
    		min = Math.min(nums[i], Math.min(nums[i]*t, nums[i]*min));
    		if(max > result)
    			result = max;
    	}
    	return result;
    }
}

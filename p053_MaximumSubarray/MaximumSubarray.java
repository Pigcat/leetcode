package p053_MaximumSubarray;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		return divide(nums,0,nums.length-1);
	}
	
	int divide(int[] nums, int left, int right)
	{
		if(left > right)
			return Integer.MIN_VALUE;
		else if(left == right)
			return nums[left];
		int mid = (left+right)/2;
		int lefttans = divide(nums, left, mid-1);
		int righttans = divide(nums, mid+1, right);
		int leftmax = 0;
		int rightmax = 0;
		
		int temp = 0;
		for(int i = mid-1; i>=left; i--)
		{
			temp += nums[i];
			if(temp > leftmax)
				leftmax = temp;
		}
		temp = 0;
		for(int i = mid+1; i<=right; i++)
		{
			temp += nums[i];
			if(temp > rightmax)
				rightmax = temp;
		}
		
		return Math.max(nums[mid]+leftmax+rightmax, Math.max(lefttans, righttans));
	}
	
	
	/*
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
        	sum += nums[i];
        	if(sum > maxSum)
        		maxSum = sum;
        	if(sum < 0)
        		sum = 0;
        }
        return maxSum;
    }
    */
}

package p055_JumpGame;

public class JumpGame {
    public boolean canJump(int[] nums) {
    	int reach = 0;
    	int i;
    	for(i = 0; i < nums.length && i <= reach; i++)
    		reach = Math.max(i+nums[i], reach);
    	return i == nums.length;
    	
    	/*
    	if(nums.length == 1)
    		return true;
    	int v = nums[0];
    	for(int i = 1; i < nums.length; i++)
    	{
    		v--;
    		if(v < 0)
    			return false;
    		if(nums[i] > v)
    			v = nums[i];
    	}
    	return true;
    	*/
    	
    	
    	/*
        if(nums.length == 1)
        	return true;
        int target = nums.length-1;
        for(int i = target - 1; i >= 0; i--)
        {
        	if(i + nums[i] >= target)
        		target = i;
        }
        if(target == 0)
        	return true;
        else
        	return false;
        */
    }
}

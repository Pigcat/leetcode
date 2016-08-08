package p045_JumpGameII;

public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1)
        	return 0;
        int ans = 1;
        int reach = nums[0];
        int i = 0;
        while(i < nums.length)
        {
        	if(reach >= nums.length - 1)
        		break;
        	ans++;
        	int t = reach;
        	for(int j = i+1; j <= t; j++)
        	{
        		if(j+nums[j] > reach)
        		{
        			i = j;
        			reach = j+nums[j];
        		}
        	}
        }
        return ans;
    }
}

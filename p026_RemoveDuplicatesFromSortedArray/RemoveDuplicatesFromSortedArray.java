package p026_RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int preNum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] != preNum)
        	{
        		ans++;
        		preNum = nums[i];
        		nums[ans-1] = nums[i];
        	}
        }
        return ans;
    }
}

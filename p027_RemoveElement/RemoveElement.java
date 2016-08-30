package p027_RemoveElement;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int sub = nums.length - 1;
        for(int cur = nums.length - 1; cur >= 0; cur--)
        {
        	if(nums[cur] == val)
        	{
        		length--;
        		nums[cur] = nums[sub];
        		sub--;
        	}
        }
        return length;
    }
}

package p001_TwoSum;


import java.util.Map;
import java.util.HashMap;

public class TwoSum_Hashtable {

	/*
	public static void main(String args[])
	{
		int[] nums = {2, 7, 11, 15};
		int target = 13;
		TwoSum test = new TwoSum();
		int[] result = test.twoSum(nums, target);
		System.out.println(result[0]+" "+result[1]);
	}
	*/
	
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
		{
			int complement = target - nums[i];
			if(map.containsKey(complement))
				return new int[]{map.get(complement), i};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
}

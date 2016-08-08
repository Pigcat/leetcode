package p001_TwoSum;

//import java.util.Arrays;

public class TwoSum {
	
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
		int length = nums.length;
		int[] indices = new int[length];
		for(int i = 0; i < length; i++)
			indices[i] = i;
		
		//quick-sort
		//int[] nums2 = Arrays.copyOf(nums, nums.length);
		//Arrays.sort(nums2);
		qSort(nums, indices, 0, length - 1);
		
		int[] result = new int[2];
		
		//loop through by two-side
		int left = 0, right = length - 1;
		while(true)
		{
			if(nums[left] + nums[right] > target)
				right--;
			else if(nums[left] + nums[right] < target)
				left++;
			else
				break;
		}
		result[0] = indices[left];
		result[1] = indices[right];
		
		//find complement by binary search
		/*
		for(int i = 0; i < length; i++)
		{
			int sub = target - nums[i];
			int loc = binarySearch(nums, sub);
			if(loc >= 0 && loc != i)
			{
				result[0] = min(indices[i], indices[loc]);
				result[1] = max(indices[i], indices[loc]);
				break;
			}
		}
		*/
		return result;
	}
	
	void qSort(int[] nums, int[] indices, int low, int high)
	{
		if (low >= high)
			return;
		int mid = (low + high)/2;
		swap(nums, indices, mid, high);
		int pivotNum = nums[high];
		int pivotInd = indices[high];
		int left = low, right = high;
		while(left < right)
		{
			while(nums[left] <= pivotNum && left < right)
				left++;
			if(left < right)
			{
				move(nums, indices, left, right);
				right--;
			}
			while(nums[right] >= pivotNum && left < right)
				right--;
			if(left < right)
			{
				move(nums, indices, right, left);
				left++;
			}
		}
		nums[left] = pivotNum;
		indices[left] = pivotInd;
		qSort(nums, indices, low, left - 1);
		qSort(nums, indices, left+1, high);
	}
	
	void move(int[] nums, int[] indices, int src, int tar)
	{
		nums[tar] = nums[src];
		indices[tar] = indices[src];
	}
	
	void swap(int[] nums, int[] indices, int src, int tar)
	{
		int tempNum = nums[tar];
		int tempInd = indices[tar];
		nums[tar] = nums[src];
		indices[tar] = indices[src];
		nums[src] = tempNum;
		indices[src] = tempInd;
	}
	
	int binarySearch(int[] nums, int sub)
	{
		int start = 0;
		int end = nums.length-1;
		while(start <= end)
		{
			int mid = (start + end)/2;
			if (sub < nums[mid])
				end = mid - 1;
			else if(sub > nums[mid])
				start = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	int min(int a, int b)
	{
		if( a < b)
			return a;
		else
			return b;
	}
	
	int max(int a, int b)
	{
		if( a < b)
			return b;
		else
			return a;
	}
	
}

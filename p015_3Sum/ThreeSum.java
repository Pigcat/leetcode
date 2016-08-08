package p015_3Sum;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++)
        {
        	//searchThreeSum(ans, nums, i+1, nums.length-1, nums[i], target);
        	int pTarget = target - nums[i];
        	int p = i+1, q = nums.length-1;
        	while( p < q )
        	{
        		if( nums[p] + nums[q] == pTarget )
        		{
        			List<Integer> temp = new ArrayList<>();
        			temp.add(nums[i]);
        			temp.add(nums[p]);
        			temp.add(nums[q]);
        			ans.add(temp);
        			p++;
        			q--;
        			//skip duplication
        			while( p < q && nums[p] == nums[p-1] )
        				p++;
        			while( p < q && nums[q] == nums[q+1] )
        				q--;
        		}
        		else if( nums[p] + nums[q] < pTarget )
        			p++;
        		else
        			q--;
        	}
        	//skip duplication
        	while( i < nums.length - 2 && nums[i] == nums[i+1] )
        		i++;
        }
        return ans;
    }
    
    void searchThreeSum(List<List<Integer>> ans, int[] nums, int p, int q, int pivot, int target)
    {
    	int pTarget = target - pivot;
    	while( p < q )
    	{
    		if( nums[p] + nums[q] == pTarget )
    		{
    			List<Integer> temp = new ArrayList<>();
    			temp.add(pivot);
    			temp.add(nums[p]);
    			temp.add(nums[q]);
    			ans.add(temp);
    			p++;
    			q--;
    			//skip duplication
    			while( p < q && nums[p] == nums[p-1] )
    				p++;
    			while( p < q && nums[q] == nums[q+1] )
    				q--;
    		}
    		else if( nums[p] + nums[q] < pTarget )
    			p++;
    		else
    			q--;
    	}
    }
}

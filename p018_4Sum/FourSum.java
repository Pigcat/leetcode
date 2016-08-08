package p018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++)
        {
        	for(int j = i+1; j < nums.length - 2; j++)
        	{
        		int pTarget = target - nums[i] - nums[j];
        		int p = j+1, q = nums.length-1;
            	while( p < q )
            	{
            		if( nums[p] + nums[q] == pTarget )
            		{
            			List<Integer> temp = new ArrayList<>();
            			temp.add(nums[i]);
            			temp.add(nums[j]);
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
        		while(j < nums.length - 2 && nums[j] == nums[j+1])
        			j++;
        	}
        	//skip duplication
        	while(i < nums.length - 3 && nums[i] == nums[i+1])
        		i++;
        }
        return ans;
    }
}

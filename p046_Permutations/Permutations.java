package p046_Permutations;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<>();
    	boolean[] states = new boolean[nums.length];
    	genPermute(ans, new ArrayList<>(), nums, states, nums.length);
    	return ans;
    }
    
    void genPermute(List<List<Integer>> ans, List<Integer> pre, int[] nums, boolean[] states, int k)
    {
    	if(k == 0)
    	{
    		ans.add(new ArrayList<>(pre));
    		return;
    	}
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(states[i] == false)
    		{
    			states[i] = true;
    			pre.add(nums[i]);
    			genPermute(ans, pre, nums, states, k-1);
    			pre.remove(pre.size()-1);
    			states[i] = false;
    		}
    	}
    }
}

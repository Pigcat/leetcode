package p095_UniqueBinarySearchTreesII;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
    	if(n == 0)
    		return new ArrayList<>();
        return genTrees(1, n);
    }
    
    List<TreeNode> genTrees(int left, int right)
    {
    	List<TreeNode> ans = new ArrayList<>();
    	if(left > right)
    	{
    		ans.add(null);
    		return ans;
    	}	
    	for(int i = left; i <= right; i++)
    	{
    		List<TreeNode> leftTrees = genTrees(left, i-1);
    		List<TreeNode> rightTrees = genTrees(i+1, right);
    		for(int j = 0; j < leftTrees.size(); j++)
    			for(int k = 0; k < rightTrees.size(); k++)
    			{
    				TreeNode node = new TreeNode(i);
    				node.left = leftTrees.get(j);
    				node.right = rightTrees.get(k);
    				ans.add(node);
    			}
    	}
    	return ans;
    }
}

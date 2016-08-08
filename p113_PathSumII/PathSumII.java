package p113_PathSumII;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        int path[] = new int[10000];
        int pathEnd = -1;
        if(root == null)
        	return ans;
        printPath(ans, path, pathEnd, root, 0, sum);
        return ans;
    }
    
    void printPath(List<List<Integer>> ans, int[] path, int pathEnd, TreeNode node, int preSum, int sum)
    {
    	pathEnd++;
    	path[pathEnd] = node.val;
    	preSum = preSum + node.val;
    	if(node.left == null && node.right == null)
    		if(preSum == sum)
    		{
    			List<Integer> t = new ArrayList<>();
    			for(int i = 0; i <= pathEnd; i++)
    				t.add(path[i]);
    			ans.add(t);
    		}
    	if(node.left != null)
    		printPath(ans, path, pathEnd, node.left, preSum, sum);
    	if(node.right != null)
    		printPath(ans, path, pathEnd, node.right, preSum, sum);
    	pathEnd--;
    }
}

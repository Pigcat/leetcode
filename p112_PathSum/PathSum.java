package p112_PathSum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        return getPathSum(root, 0, sum);
    }
    
    boolean getPathSum(TreeNode node, int preSum, int tar)
    {
    	if(node.left == null && node.right == null)
    		if(preSum + node.val == tar)
    			return true;
    		else
    			return false;
    	preSum = preSum + node.val;
    	if(node.left != null && getPathSum(node.left, preSum, tar))
    		return true;
    	if(node.right != null && getPathSum(node.right, preSum, tar))
    		return true;
    	return false;
    }
}

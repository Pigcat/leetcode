package p101_SymmetricTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
        return subsAreSymmetric(root.left, root.right);
    }
    
    boolean subsAreSymmetric(TreeNode left, TreeNode right)
    {
    	if(left == null && right == null)
    		return true;
    	if(left == null || right == null)
    		return false;
    	if(left.val != right.val)
    		return false;
    	if( !subsAreSymmetric(left.left, right.right) || !subsAreSymmetric(left.right, right.left))
    		return false;
    	return true;
    }
}

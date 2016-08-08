package p110_BalancedBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BalancedBinaryTree {
	
	/*
	public static void main(String args[])
	{
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(3);
		tree.left.left = new TreeNode(3);
		BalancedBinaryTree test = new BalancedBinaryTree();
		test.isBalanced(tree);
	}
	*/
	
    public boolean isBalanced(TreeNode root) {
        setDepth(root);
        if(root == null)
        	return true;
        if(tryBalanced(root))
        	return true;
        return false;
    }
    
    void setDepth(TreeNode node)
    {
    	if(node == null)
    		return;
    	setDepth(node.left);
    	setDepth(node.right);
    	if(node.left == null && node.right == null)
    		node.val = 1;
    	else if(node.left != null && node.right == null)
    		node.val = node.left.val+1;
    	else if(node.left == null && node.right != null)
    		node.val = node.right.val+1;
    	else
    		node.val = Math.max(node.left.val, node.right.val)+1;
    }
    
    boolean tryBalanced(TreeNode node)
    {
    	int l,r;
    	if(node.left != null)
    	{
    		if(!tryBalanced(node.left))
    			return false;
    		l = node.left.val;
    	}
    	else
    		l = 0;
    	if(node.right != null)
    	{
    		if(!tryBalanced(node.right))
    			return false;
    		r = node.right.val;
    	}
    	else
    		r = 0;
    	if(l-r >= -1 && l-r <= 1)
    		return true;
    	else
    		return false;
    }
    
	//
	/*
	boolean b1 = false;
	boolean b2 = false;
	int h1 = 0;
	int h2 = 0;
	
    public boolean isBalanced(TreeNode root) {
        if(depth(root, 0))
        {
        	if(b1 == false && b2 == false)
        		return true;
        	else if(b1 == true && b2 == false)
        	{
        		if(h1 <= 1)
        			return true;
        		else
        			return false;
        	}
        	else
        		return true;
        }
        else
        	return false;
        
    }
    
    private boolean depth(TreeNode root, int depth)
    {
    	if(root == null)
    		return true;
    	if(root.left == null && root.right == null)
    	{
    		if(b1 == false && b2 == false)
    		{
    			h1 = depth;
    			b1 = true;
    			return true;
    		}
    		else if(b1 == true && b2 == false)
    		{
    			if(depth == h1 + 1 || depth == h1 - 1)
    			{
    				h2 = depth;
    				b2 = true;
    				return true;
    			}
    			else if(depth == h1)
    				return true;
    			else
    				return false;
    		}
    		else
    		{
    			if(depth != h1 && depth != h2)
    				return false;
    			else
    				return true;
    		}
    	}
    	if(root.left != null && !depth(root.left, depth+1))
    		return false;
    	if(root.right != null && !depth(root.right,  depth+1))
    		return false;
    	return true;
    }
    */
}

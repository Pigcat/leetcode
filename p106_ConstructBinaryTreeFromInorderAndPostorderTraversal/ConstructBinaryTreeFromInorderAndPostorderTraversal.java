package p106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0)
        	return null;
        return generateNode(inorder, 0, len-1, postorder, 0, len-1);
    }
    
    TreeNode generateNode(int[] inorder, int inP, int inQ, int[] postorder, int poP, int poQ)
    {
    	TreeNode node = new TreeNode(postorder[poQ]);
    	if(inP == inQ)
    		return node;
    	int inLoc = search(inorder, inP, inQ, postorder[poQ]);
    	int preLen = inLoc - inP;
    	int sufLen = inQ - inLoc;
    	if(preLen > 0)
    		node.left = generateNode(inorder, inP, inLoc - 1, postorder, poP, poP + preLen -1);
    	if(sufLen > 0)
    		node.right = generateNode(inorder, inLoc + 1, inQ, postorder, poP + preLen, poQ - 1);
    	return node;
    }
    
    int search(int[] inorder, int inP, int inQ, int target)
    {
    	for(int i = inP; i <= inQ; i++)
    		if(inorder[i] == target)
    			return i;
    	return -1;
    }
}

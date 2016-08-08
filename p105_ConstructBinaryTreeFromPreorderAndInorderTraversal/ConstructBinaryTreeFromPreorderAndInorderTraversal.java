package p105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0)
        	return null;
        return generateNode(preorder, 0, len-1, inorder, 0, len-1);
    }
    
    TreeNode generateNode(int[] preorder, int preP, int preQ, int[] inorder, int inP, int inQ)
    {
    	TreeNode node = new TreeNode(preorder[preP]);
    	if(preP == preQ)
    		return node;
    	int inLoc = search(inorder, inP, inQ, preorder[preP]);
    	int preLen = inLoc - inP;
    	int sufLen = inQ - inLoc;
    	if(preLen > 0)
    		node.left = generateNode(preorder, preP + 1, preP + preLen , inorder, inP, inLoc - 1);
    	if(sufLen > 0)
    		node.right = generateNode(preorder, preP + preLen + 1, preQ, inorder, inLoc + 1, inQ);
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

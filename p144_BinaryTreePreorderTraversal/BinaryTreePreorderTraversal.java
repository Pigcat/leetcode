package p144_BinaryTreePreorderTraversal;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty())
        {
        	if(node != null)
        	{
        		ans.add(node.val);
        		if(node.right != null)
        			stack.push(node.right);
        		node = node.left;
        	}
        	else
        		node = stack.pop();
        }
        return ans;
    }
}

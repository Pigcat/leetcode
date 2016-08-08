package p094_BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty())
        {
        	if(node != null)
        	{
        		stack.push(node);
        		node = node.left;
        	}
        	else
        	{
        		node = stack.pop();
        		ans.add(node.val);
        		node = node.right;
        	}
        }
        return ans;
    }
}

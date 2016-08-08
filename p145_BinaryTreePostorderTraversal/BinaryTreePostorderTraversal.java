package p145_BinaryTreePostorderTraversal;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nStack = new Stack<>();
        Stack<Boolean> sStack = new Stack<>();
        TreeNode node = root;
        while(node != null || !nStack.isEmpty())
        {
        	if(node != null)
        	{
        		nStack.push(node);
        		sStack.push(false);
        		node = node.left;
        	}
        	else
        	{
        		node = nStack.pop();
        		if(!sStack.pop())
        		{
        			nStack.push(node);
        			sStack.push(true);
        			node = node.right;
        		}
        		else
        		{
        			ans.add(node.val);
        			node = null;
        		}
        	}
        }
        return ans;
    }
}

package p102_BinaryTreeLevelOrderTraversal;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	if(root == null)
    		return ans;
    	else
    	{
    		List<Integer> t = new ArrayList<>();
    		t.add(root.val);
    		ans.add(t);
    		queue.add(root);
    	}
    	while(!queue.isEmpty())
    	{
    		List<Integer> tList = new ArrayList<>();
    		Queue<TreeNode> tQueue = new LinkedList<>();
    		while(!queue.isEmpty())
    		{
    			TreeNode temp = queue.remove();
    			if(temp.left != null)
    			{
    				tList.add(temp.left.val);
    				tQueue.add(temp.left);
    			}
    			if(temp.right != null)
    			{
    				tList.add(temp.right.val);
    				tQueue.add(temp.right);
    			}
    		}
    		if(!tList.isEmpty())
    			ans.add(tList);
    		queue = tQueue;
    	}
    	return ans;
    }
}

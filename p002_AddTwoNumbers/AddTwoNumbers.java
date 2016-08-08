package p002_AddTwoNumbers;



class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addOne = false;
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        int l1_val, l2_val;
        while(l1 != null || l2 != null || addOne == true)
        {
        	tempNode.next = new ListNode(0);
        	tempNode = tempNode.next;
        	
        	l1_val = ( l1!=null ? l1.val : 0);
        	l2_val = ( l2!=null ? l2.val : 0);
        	tempNode.val = l1_val + l2_val;
        	if(addOne == true)
        		tempNode.val++;
        	if(tempNode.val >= 10)
        	{
        		tempNode.val -= 10;
        		addOne = true;
        	}
        	else
        		addOne = false;
        	//attention: null pointer
        	if(l1 != null)
        		l1 = l1.next;
        	if(l2 != null)
        		l2 = l2.next;
        }
        return result.next;
    }
}

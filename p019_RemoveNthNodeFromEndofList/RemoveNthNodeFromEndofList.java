package p019_RemoveNthNodeFromEndofList;

import java.util.Map;
import java.util.HashMap;

// Definition for singly-linked list
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RemoveNthNodeFromEndofList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for(int i = n; i >= 0; i--)
			second = second.next;
		while(second != null)
		{
			second = second.next;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}
	
	/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode enu = head;
        int i = 1;
        for(; enu != null; i++)
        {
        	map.put(i, enu);
        	enu = enu.next;
        }
        if( i - n == 1)
        	head = head.next;
        else if(n == 1)
        {
        	map.get(i - 2).next = null;
        }
        else
        {
        	ListNode delPre = map.get(i - n - 1);
        	delPre.next = delPre.next.next;
        }
        return head;   
    }
    */
}

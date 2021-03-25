package 链表;

import java.util.*;

/**
 * 快慢指针
 */
public class 倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {


        ListNode fast = head;
        ListNode slow = head;

        while (k>0){
            fast=fast.next;
            k=k-1;
        }

        while (fast!=null){
            fast = fast.next;
            slow=slow.next;
        }
        return slow;
    }


    /**
     * 压栈
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {


        Deque<ListNode> deque = new LinkedList<>();

        while (head!=null){
            deque.push(head);
            head=head.next;
        }



        ListNode temp = null;

        for(int i=0;i<k;i++){
            temp = deque.pop();
        }
        return temp;






    }
}

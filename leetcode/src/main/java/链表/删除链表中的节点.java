package 链表;

/**
 * 在只给定被删除节点的情况下，删除该节点。
 */
public class 删除链表中的节点 {

    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;

    }

}

package 链表;

public class 二进制链表转整数 {

    public int getDecimalValue(ListNode head) {

        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(s.toString(), 2);


    }
}

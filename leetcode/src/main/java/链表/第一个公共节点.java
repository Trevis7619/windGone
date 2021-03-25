package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 *@author chenyijie
 *@Date  2021/3/26 12:18 上午
 *
 * 优化1:双指针
 * 优化2:先切割到相同长度;因为end是一样的
 */
public class 第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();
        //先把链表A的结点全部存放到集合set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
        return null;


    }
}

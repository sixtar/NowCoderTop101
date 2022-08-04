package 链表.BM1反转链表;

import java.util.*;

/**
 * dumpHead虚拟头结点，模拟元素依次插入到虚拟头结点和第一个元素之间
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode curNode = head.next;
        ListNode last = head;
        while(curNode != null){
            // 断开当前head的下一个结点curr
            last.next = curNode.next;
            // 把curr移到dumpHead和他当前后一个结点之间
            curNode.next = dumpHead.next;
            dumpHead.next = curNode;

            curNode = last.next;

        }

        return dumpHead.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
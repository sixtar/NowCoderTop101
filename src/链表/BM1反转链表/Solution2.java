package 链表.BM1反转链表;

/**
 * 做法2是用一个pre存储当前元素的上一个元素，在几个元素之间腾挪next的值
 * 思路源自单链表主要解题思路就是定义一些指针然后更改各个节点的next
 */
public class Solution2 {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        // 默认pre为null, cur为head
        ListNode pre = null;
        ListNode cur = head;
        // 循环终止条件是curr为空
        while(cur != null){
            // 临时存储当前节点的下一个节点
            ListNode temp = cur.next;
            // 当前节点指向pre
            cur.next = pre;
            // 下一个pre节点更新为cur，下一个当前节点更新为temp
            pre = cur;
            cur = temp;

        }

        // 返回pre即可，因为循环结束时cur已经为空
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
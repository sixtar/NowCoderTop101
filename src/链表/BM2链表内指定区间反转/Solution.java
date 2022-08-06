package 链表.BM2链表内指定区间反转;

import 链表.BaseListNodeSolution;

import java.util.Arrays;

/**
 * 解法和整个链表翻转一致，但是要考虑翻转之后的衔接和边界条件
 */
public class Solution extends BaseListNodeSolution {

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return null;
        }
        if (head.next == null || m == n) {
            return head;
        }
        ListNode cur = head;
        int curIdx = 0;
        ListNode realPre = null;
        while ((curIdx < m - 1) && cur != null) {
            realPre = cur;
            cur = cur.next;
            curIdx++;
        }
        // 排除m比n大的情况
        if (cur == null) {
            return head;
        }
        // 接下来处理翻转
        // 暂存第一个元素,用来指向后续节点
        ListNode localFirst = cur;
        // 局部的pre节点，默认初始化为空
        ListNode localPre = null;
        while ((curIdx <= n - 1) && cur != null) {
            ListNode temp = cur.next;
            cur.next = localPre;
            localPre = cur;
            cur = temp;
            curIdx++;
        }
        // 第一个元素指向后续链表
        if (cur != null) {
            localFirst.next = cur;
        }
        if (realPre != null) {
            realPre.next = localPre;
        } else { // 特殊情况从一开始就翻转导致realPre为null {3,5},1,2
            return localPre;
        }

        return head;
    }

    public static void main(String[] args) {
//        ListNode listNode = genLinkListByList(Arrays.asList(1, 2, 3, 4, 5));
//        printLinkList(listNode);
//        ListNode newListNode = new Solution().reverseBetween(listNode, 2, 4);
//        printLinkList(newListNode);
        // 数组越界问题
        ListNode listNode = genLinkListByList(Arrays.asList(3, 5));
        printLinkList(listNode);
        // ListNode newListNode = new Solution().reverseBetween(listNode, 1, 1);
        ListNode newListNode = new Solution().reverseBetween(listNode, 1, 2);
        printLinkList(newListNode);
    }

}

package 链表.BM2链表内指定区间反转;

import 链表.BaseListNodeSolution;

import java.util.Arrays;

/**
 * 这种题目还是用虚拟头结点好做一点，但是伐木机的做法比整个链表翻转里我那个虚拟头结点清晰
 * 他是dummy永远不变，然后定义了一个pre初始等于dummy作为局部翻转的dummy节点，再定义一个temp参与变量交换
 * 翻转的思路是抽书法，就是把当前节点的下一个节点插到pre和当前节点中间的位置
 */
public class Solution2 extends BaseListNodeSolution {

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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 先找到pre的位置，因为一开始指向dummy节点，所以即使是从头开始的翻转也不用单独判断
        int c1 = m - 1;
        while (c1 > 0) {
            pre = pre.next;
            c1--;
        }

        //开始局部的翻转，需要操作n-m次
        ListNode cur = pre.next;
        // 实际抽出来处理的是当前节点的下一个节点
        ListNode temp;
        for (int i = 0; i < n - m; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            // 好像cur的位置自动后移了，所以不用改动他
        }
        // 返回虚拟头结点的下一个
        return dummy.next;
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
        ListNode newListNode = new Solution2().reverseBetween(listNode, 1, 2);
        printLinkList(newListNode);
    }

}

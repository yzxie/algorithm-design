package linkedchain;

import java.util.Stack;

/**
 * @author xieyizun
 * @date 13/3/2019 11:09
 * @description:
 */
public class HuiwenLinkedChain {

    /**
     * O(n)时间复杂度，O(1)空间复杂度
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || (head != null && head.next == null)) {
            return true;
        }

        // 获取链表长度
        int len = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            len++;
            tempHead = tempHead.next;
        }

        // 获取回文链表的前半部分的最后一个下标
        int preHalfEndIndex = len % 2 == 0 ? (len-1)/2 : (len/2)-1;

        // temp2Head为回文链表的后半部分的头结点
        int index = 0;
        ListNode temp2Head = head;
        while (index <= preHalfEndIndex) {
            temp2Head = temp2Head.next;
            index++;
        }
        if (len % 2 != 0 && temp2Head.next != null) {
            temp2Head = temp2Head.next;
        }

        // 反转后部分链表
        ListNode tail = chainReverse(temp2Head);

        // 前半部分从head开始，后半部分从tail开始
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }

        return true;
    }

    // 反转链表
    private ListNode chainReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode backward = head;
        ListNode forward = head.next;
        head.next = null;

        while (forward != null) {
            head = forward;
            forward = forward.next;
            head.next = backward;
            backward = head;
        }

        return head;
    }

    /**
     * 基于FILO栈实现，O(n）时间复杂度，O(n）空间复杂度
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || (head != null && head.next == null)) {
            return true;
        }

        int len = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            len++;
            tempHead = tempHead.next;
        }
        int preHalfEndIndex = len % 2 == 0 ? (len-1)/2 : (len/2)-1;
        Stack<Integer> stack = new Stack();
        int index = 0;

        while (index <= preHalfEndIndex) {
            stack.push(head.val);
            index++;
            head = head.next;
        }

        if (len % 2 != 0 && head.next != null) {
            head = head.next;
        }

        while(head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

package linkedchain;

/**
 * @author xieyizun
 * @date 13/3/2019 11:07
 * @description: 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedChain {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 反转头结点
        // 反转每个节点时，需要保存当前节点和当前节点的下一个节点后，才对当前节点进行反转
        ListNode backward = head;
        ListNode forwad =  head.next;
        // 此时可以反转head的next为null了
        head.next = null;

        // 反转其他节点
        while (forwad != null) {
            head = forwad; // head执行原先的head.next
            forwad = head.next; // forward指向head.next.next

            // 此时实现head.next的反转，指向head
            head.next = backward; // head.next执行head，完成了head.next的反转
            backward = head; // backward执行head.next
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLinkedChain reverseLinkedChain = new ReverseLinkedChain();
        head = reverseLinkedChain.reverseList(head);

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}

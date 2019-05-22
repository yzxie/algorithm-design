package linkedchain;

/**
 * @author xieyizun
 * @date 22/5/2019 22:11
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class SortedArrayRemoveDup {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode beforeNode = head;
        ListNode nextNode = head.next;
        // 相等则删除nextNode，否则均向前移动一步
        while (nextNode != null) {
            if (beforeNode.val == nextNode.val) {
                ListNode toDeletedNode = nextNode;
                nextNode = nextNode.next;
                beforeNode.next = nextNode;
                toDeletedNode = null;
            } else {
                beforeNode = nextNode;
                nextNode = nextNode.next;
            }
        }

        return head;
    }
}

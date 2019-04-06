package linkedchain;

/**
 * @author xieyizun
 * @date 6/4/2019 22:49
 * @description:
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            ListNode head = newList;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    newList.next = l1;
                    l1 = l1.next;
                } else {
                    newList.next = l2;
                    l2 = l2.next;
                }
                newList = newList.next;
            }

            if (l1 != null) {
                newList.next = l1;
            }

            if (l2 != null) {
                newList.next = l2;
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        MergeList mergeList = new MergeList();
        ListNode list = mergeList.mergeTwoLists(l1, l2);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}

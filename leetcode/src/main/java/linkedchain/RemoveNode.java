package linkedchain;

/**
 * @author xieyizun
 * @date 13/3/2019 11:04
 * @description: 203. 移除链表元素 https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveNode {

    // 核心思路：如果一个节点要被删除，则将这个节点的前一个节点的next指向当前需要被删除的节点的next
    public ListNode removeElements(ListNode head, int val) {
        // 记录当前假设需要被删除的节点的前一个节点，这样当该假设需要被删除的节点就是需要被删除的节点，
        // 则在删除前，将该需要被删除的节点的前一个节点执行需要被删除的节点的后一个节点，
        // 然后再将该节点删除
        ListNode preNode = null;
        // 假设需要被删除的节点
        ListNode toDeletedNode = head;

        while (toDeletedNode != null) {
            if (toDeletedNode.val == val) {
                // 如果需要删除的就是head，则将head指向下一个节点
                if (head == toDeletedNode) {
                    head = toDeletedNode.next;
                }

                // 前移preNode的next
                if (preNode != null) {
                    // preNode的next指向toDeletedNode的next
                    preNode.next = toDeletedNode.next;
                }

                // 删除toDeletedNode
                toDeletedNode = null;

                // 前移toDeletedNode到preNode
                if (preNode != null) {
                    toDeletedNode = preNode.next;
                } else {
                    toDeletedNode = head;
                }
            } else {
                // 前移preNode指向toDeletedNode，
                preNode = toDeletedNode;
                // 前移toDeletedNode
                toDeletedNode = toDeletedNode.next;
            }
        }

        return head;
    }
}

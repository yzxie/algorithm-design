/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/16
 * Description:
 **/
public class LRUCache {
    // 解题思路：
    // 仿照Java的linkedhashmap来维护一个双向链表，每次访问一个节点或者新增一个节点则放到链表尾部
    // 删除节点，则删除链表首部节点
    // 数据存储使用开放地址哈希表，就冲突节点放在下一个空位置，而不是使用链表哈希的方式

    private Node head;
    private Node tail;

    private int capacity;
    private int size;
    private Node[] table;


    public LRUCache(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.table = new Node[capacity];
        }
    }

    public int get(int key) {
        if (capacity <= 0 || key < 0 || size == 0) {
            return -1;
        }

        // 目标位置
        int arrayIndex = key % capacity;
        Node target = table[arrayIndex];

        // 存在冲突不在目标位置
        if (target == null || target.key != key) {
            int nextLocation = (arrayIndex + 1) % capacity;
            while (nextLocation != arrayIndex) {
                Node node = table[nextLocation];
                if (node != null && node.key == key) {
                    // 找到
                    target = node;
                    break;
                } else {
                    nextLocation = (nextLocation + 1) % capacity;
                }
            }
        }

        if (target != null && target.key == key) {
            // 维护双向链表，放到链表尾部
            adjustNodeAccessLocation(target);

            return target.value;
        } else {
            // 未找到
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0 || key < 0) {
            return;
        }

        Node target = null;
        // 查找当前节点是否存在，存在则更新，否则插入
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            if (node != null && node.key == key) {
                target = node;
                break;
            }
        }

        if (target != null) {
            // 更新
            target.value = value;
            adjustNodeAccessLocation(target);

        } else {
            // 新增
            // 容量满了，删除最近最少访问的元素，即head节点
            if (size == capacity) {
                Node toDeletedNode = head;
                head = head.next;
                if (head == null) {
                    tail = null;
                } else {
                    head.pre = null;
                }

                table[toDeletedNode.arrayIndex] = null;
                toDeletedNode = null;
                size--;
            }

            // 取模获取数组下标，如果已经存在元素，则往下查找直到查找到一个空闲位置，
            // 注意是环形数组，直到当前数组下标的前一个位置
            int arrayIndex = key % capacity;
            Node node = table[arrayIndex];

            Node newNode = new Node(key, value);

            if (node == null) {
                newNode.arrayIndex = arrayIndex;
                table[arrayIndex] = newNode;
            } else {
                // 存在冲突，遍历直到找到一个空位置，环形数组故与capacity取模，避免越界问题
                int nextLocation = (arrayIndex + 1) % capacity;

                // 查找直到回到原位置
                while (nextLocation != arrayIndex) {
                    if (table[nextLocation] == null) {
                        // 找到
                        newNode.arrayIndex = nextLocation;
                        table[nextLocation] = newNode;
                        break;
                    } else {
                        // 往下查找
                        nextLocation = (nextLocation + 1) % capacity;
                    }
                }
            }
            size++;
            target = newNode;
            // 新节点追加到双向链表尾部
            addNewNodeToTail(target);
        }
    }

    private void adjustNodeAccessLocation(Node target) {
        // 存在两个以上节点且不是访问尾结点
        if (head != tail && target != tail) {
            // 访问头结点
            if (head == target) {
                head = head.next;
                head.pre = null;

                tail.next = target;
                target.pre = tail;
                tail = target;
            } else {
                // 访问中间节点
                // 调整当前节点的双向链表的前后节点
                target.pre.next = target.next;
                target.next.pre = target.pre;

                // 当前节点放到链表尾部
                tail.next = target;
                target.pre = tail;
                tail = target;
            }
        }
    }

    private void addNewNodeToTail(Node target) {
        if (head == null && tail == null) {
            head = tail = target;
        } else {
            tail.next = target;
            target.pre = tail;
            tail = target;
        }
    }

    private class Node {
        public int key;
        public int value;
        // 优化性能：当前在哈希表数组的下标，O(1)时间复杂度删除
        public int arrayIndex;
        public Node pre;
        public Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

package com.yugutou.charpter5_queue_hash.level3;

/**
 * @author dongdong
 * @Date 2023/11/25 15:53
 * 实现LRUCache
 * 使用双向链表来实现
 * 当一个元素插入的时候，首先看是否需要判断链表的长度，然后直接插入在链表的尾部
 * 当一个元素被访问的时候，需要把它移动到链表头部
 *
 */
public class LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(2);
        lRUCache.put(1,1);//缓存是{1=1}
        lRUCache.put(2,2);//缓存是{1=1,2=2}
        System.out.println(lRUCache.get(1));
//返回1
        lRUCache.put(3,3);//该操作会使得关键字2作废，缓存是{1=1,3=3}
        System.out.println(lRUCache.get(2));
//返回-1（未找到）
        lRUCache.put(4,4);//该操作会使得关键字1作废，缓存是{4=4,3=3)
        System.out.println(lRUCache.get(1));
//返回-1（未找到）
        System.out.println(lRUCache.get(3));
//返回3
        System.out.println(lRUCache.get(4));
//返回4
    }
    class DLinkedList {
        int key;
        int val;
        DLinkedList pre;
        DLinkedList next;

        public DLinkedList(){
        }
        public DLinkedList(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    private int capacity;
    private int size;
    private DLinkedList head;
    private DLinkedList tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    //当一个元素被访问的时候，先判断是否存在，然后需要把它移动到链表头部
    int get(int key) {
        DLinkedList temp = head, cur = null;
        int val = -1;
        cur = findNode(key);
        if (cur != null) {
            //moveToHead
            moveToHead(cur);
            val = cur.val;
        }
        return val;
    }

    //当一个元素插入的时候，首先需要判断链表的长度，然后直接插入在链表的尾部
    void put(int key, int value) {
        DLinkedList temp = head;
        DLinkedList tar = findNode(key);
        if (tar == null) {
            DLinkedList newNode = new DLinkedList(key, value);
            //addToHead
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //removeTail
                removeTail();
                --size;
            }
        } else {
            tar.val = value;
            //moveToHead
            moveToHead(tar);
        }
    }

    public DLinkedList findNode(int key) {
        DLinkedList temp = head, cur = null;;
        while (temp.next != null) {
            if (temp.key == key) {
                cur = temp;
                break;
            }
            temp = temp.next;
        }
        return cur;
    }

    public void moveToHead(DLinkedList node) {
        removeNode(node);
        /*node.pre.next = node.next;
        node.next.pre = node.pre;*/

        addToHead(node);
        /*temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;*/
    }

    public void addToHead(DLinkedList node) {
        DLinkedList temp;
        temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;
    }

    public void removeTail() {
        DLinkedList temp = tail.pre;

        removeNode(temp);
    }

    public void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

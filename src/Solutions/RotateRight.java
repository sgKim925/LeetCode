package Solutions;

public class RotateRight {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    public class ListNode {
        ListNode next;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = dummy.next;
        int count=1;
        while(tail.next!=null) {
            count++;
            tail = tail.next;
        }
        tail.next = head;
        for(int i=0; i<count-(k%(count)); i++) {
            /*
            * Java中 int，float。。。等基本类型变量存储在栈中，存储的是变量自身
            * Object，String，自定义类 等引用类型变量存储在堆中，存储的是物理空间的地址
            * 即 引用类型变量可以近似理解为指针
            */
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;

        return head;
    }
}

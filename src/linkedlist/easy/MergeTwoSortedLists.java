package linkedlist.easy;

public class MergeTwoSortedLists {
    // https://leetcode.com/problems/merge-two-sorted-lists/
    // 21. Merge Two Sorted Lists
    // Easy
    // Tags: Linked List, Recursion

    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1 == null & l2 == null) return null;
        ListNode head = new ListNode();
        ListNode cur = head;
        int temp1 = l1.val;
        int temp2 = l2.val;
        while(l1 != null && l2 != null){
            if(temp1 < temp2){
                cur.val = temp1;
                l1 = l1.next;
                if(l1 != null) temp1 = l1.val;
            } else {
                cur.val = temp2;
                l2 = l2.next;
                if(l2 != null) temp2 = l2.val;
            }
            cur.next = new ListNode();
            cur = cur.next;
        }
        while(l1 != null){
            cur.val = l1.val;
            l1 = l1.next;
            if(l1 == null) break;
            cur.next = new ListNode();
            cur = cur.next;
        }
        while(l2 != null){
            cur.val = l2.val;
            l2 = l2.next;
            if(l2 == null) break;
            cur.next = new ListNode();
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = m.mergeTwoLists(l1, l2);
        while(res != null){
            System.out.print(res.val + " "); // [1,1,2,3,4,4]
            res = res.next;
        }
    }
}
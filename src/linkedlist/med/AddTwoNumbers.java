package linkedlist.med;

import java.math.BigInteger;

public class AddTwoNumbers {

    // NumberFormatExceptions After Solving
    // Accepted With BigInteger Only

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(l1 != null){
            sb.append(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }
        BigInteger sum = new BigInteger(sb.reverse().toString()).add(new BigInteger(sb2.reverse().toString()));
        String sumStr = String.valueOf(sum);
        StringBuilder sb3 = new StringBuilder(sumStr);
        sb3.reverse();
        ListNode head = new ListNode();
        ListNode cur = head;
        for(int i = 0; i < sb3.length(); i++) {
            cur.val = sb3.charAt(i) - '0';
            if(i != sb3.length() - 1){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = a.addTwoNumbers(l1, l2);
        while(res != null){
            System.out.print(res.val + " "); // [7,0,8]
            res = res.next;
        }
        System.out.println("\n");

        AddTwoNumbers b = new AddTwoNumbers();
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode res2 = b.addTwoNumbers(l3, l4);
        while(res2 != null) {
            System.out.print(res2.val + " "); // [0]
            res2 = res2.next;
        }
        System.out.println("\n");

        AddTwoNumbers c = new AddTwoNumbers();
        ListNode l5 = new ListNode(9);
        l5.next = new ListNode(9);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(9);
        l5.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l6 = new ListNode(9);
        l6.next = new ListNode(9);
        l6.next.next = new ListNode(9);
        l6.next.next.next = new ListNode(9);
        l6.next.next.next.next = new ListNode(9);
        ListNode res3 = c.addTwoNumbers(l5, l6);
        while(res3 != null){
            System.out.print(res3.val + " "); // [1,0,0,0,0,0,0,0,0,0,0]
            res3 = res3.next;
        }

        AddTwoNumbers d = new AddTwoNumbers();
        ListNode l7 = new ListNode(1);
        ListNode cur = l7;
        for(int i = 0; i < 24; i++){
            cur.next = new ListNode(0);
            cur = cur.next;
        }
        cur.next = new ListNode(1);
        ListNode l8 = new ListNode(5);
        l8.next = new ListNode(6);
        l8.next.next = new ListNode(4);
        ListNode res4 = d.addTwoNumbers(l7, l8);
        while(res4 != null){
            System.out.print(res4.val + " "); // [6,0,4,0,5,6,4]
            res4 = res4.next;
        }
    }
}
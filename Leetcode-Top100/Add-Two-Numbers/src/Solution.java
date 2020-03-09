package addtwonumbers;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/9 20:05
 *
 * @author crwen
 * @create 2020-03-09-20:05
 * @since JDK 1.8
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //    List<Integer> list1 = new ArrayList<>();
    //    List<Integer> list2 = new ArrayList<>();
    //    List<Integer> list = new ArrayList<>();
    //    ListNode head = l1;
    //    while (head != null) {
    //        list1.add(head.val);
    //        head = head.next;
    //    }
    //    head = l2;
    //    while (head != null) {
    //        list2.add(head.val);
    //        head = head.next;
    //    }
    //
    //    int i = 0;
    //    int j = 0;
    //    int step = 0;
    //    while (i < list1.size() || j < list2.size()) {
    //        int sum = 0;
    //        if (i < list1.size())
    //            sum += list1.get(i++);
    //        if (j < list2.size())
    //            sum += list2.get(j++);
    //        sum += step;
    //        step = 0;
    //        list.add(sum % 10);
    //        if (sum > 9)
    //            step ++;
    //    }
    //    if (step > 0)
    //        list.add(1);
    //
    //    ListNode node = new ListNode(list.get(0));
    //    ListNode cur = node;
    //    for (int k = 1; k < list.size(); k++) {
    //        cur.next = new ListNode(list.get(k));
    //        cur = cur.next;
    //    }
    //
    //    return node;
    //}


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        int step = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = step + x + y;
            step = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (step > 0)
            cur.next = new ListNode(1);
        return node.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode node = solution.addTwoNumbers(l1, l2);

        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }

    }

}
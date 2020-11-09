//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode dummdyHead = new ListNode(-1);
        ListNode node = dummdyHead;
        int step = 0;

        while (node1 != null || node2 != null) {
            int a = node1 == null ? 0 : node1.val;
            int b = node2 == null ? 0 : node2.val;

            int sum = a + b + step;
            node.next = new ListNode(sum % 10);
            node = node.next;
            step = sum / 10;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;

        }
        if (step > 0)
            node.next = new ListNode(step);
        return dummdyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

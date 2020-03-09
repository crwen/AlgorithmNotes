
**[题目传送门](https://leetcode.com/problems/add-two-numbers/)**

**题目描述**


给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


**示例:**
```html
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

通过观察，我们可以发现计算的顺序与链表中元素的顺序一致，即链表的排列顺序恰好与我们计算的顺序一致，所以我们可以直接按顺序去除链表中的元素相加就好了。

```java
class Solution {

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

}
```
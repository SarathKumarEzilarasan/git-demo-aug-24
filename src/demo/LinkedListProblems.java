package demo;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class LinkedListProblems {

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Input
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        // Reverse Nodes in k-Group
        ListNode result = reverse(head, k);
        printList(result); // Output: 2 -> 1 -> 4 -> 3 -> 5
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // Reverse Nodes in k-Group
    static ListNode reverse(ListNode head, int k)
    {
        // If head is NULL or K is 1 then return head
        if (head == null || head.next == null)
            return head;

        // creating dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Initializing three points prev, curr, next
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode next = dummy;

        // Calculating the length of linked list
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Iterating till next is not NULL
        while (next != null) {
            curr = prev.next; // Curr position after every
            // reverse group
            next = curr.next; // Next will always next to
            // curr
            int toLoop
                    = count > k
                    ? k
                    : count - 1; // toLoop will set to
            // count - 1 in case of
            // remaining element

            for (int i = 1; i < toLoop; i++) {
                // 4 steps as discussed above
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr; // Setting prev to curr
            count -= k; // Update count
        }
        return dummy.next; // dummy -> next will be our new
        // head for output linked
        // list
    }
}

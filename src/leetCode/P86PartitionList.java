package leetCode;

public class P86PartitionList {
	static public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode headp = new ListNode(0);
		headp.next = head;
		ListNode ptr = headp;
		ListNode ptr_bk = headp;

		while (ptr.next != null) {
			ListNode ptrn = ptr.next;

			if (ptrn.val < x) {
				if (ptrn == ptr_bk.next){
					ptr_bk = ptrn;
					ptr =ptrn;
				}
				else {
					ListNode temp1 = ptrn.next;
					ListNode temp2 = ptr_bk.next;

					ptr_bk.next = ptrn;
					ptrn.next = temp2;
					ptr_bk = ptrn;
					ptr.next = temp1;
				}
			} else {
				ptr = ptrn;
			}
		}
		return headp.next;
	}

	public static void main(String[] args) {
		ListNode input = ListNode.constructALinkList("143252");

		ListNode.printLinkList(partition(input, 3));
	}
}

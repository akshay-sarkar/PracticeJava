package learn.datastructure;

/* Assumed as Singly LinkedList */
public class SinglyLinkedList {

	/* LInked list Node */
	Node head = null;

	public class Node {
		int value;
		Node next;

		Node(int val) {
			value = val;
			next = null;
		}
	}

	/* Add to Linked List */
	/* Direction 1 at end; Direction 0 in beginning */
	public void addToLinkedList(int direction, int val) {
		Node newNode = new Node(val);
		// if node is empty
		if (head == null) {
			head = newNode;
			return;
		}

		if (direction == 1) {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	/* Remove from the LinkedList */
	/* Direction 1 at end; Direction 0 in beginning */
	public void removeLinkedList(int direction) {
		if (head == null) {
			System.out.println("Nothing to empty in Linkedlist!!");
		}
		if (direction == 1) {
			Node temp = head;
			while (temp.next != null && temp.next.next != null)
				temp = temp.next;

			if (temp == head) {
				head.next = null;
			} else {
				temp.next = null;
			}
		} else { // removing head from the beginning
			head = head.next;
		}
	}

	/* Remove from particular Position in LinkedList */
	public void removElementFromParticularPostion(int postion) {
		int pos = postion;
		if (head == null && pos <= 0)			
			System.out.println("Nothing to empty in Linkedlist!!");

		Node temp = head, prev = null;
		while (temp.next != null && pos != 1) {
			prev= temp;
			temp = temp.next;
			--pos;
		}

		if (temp.next != null && temp.next.next != null && pos == 1) {
			head = temp.next;
		} else if(temp.next != null && pos == 1){
			prev.next = temp.next;
		}else if(temp.next == null && pos == 1){
			prev.next = null;
		}else {
			System.out.println("Nothing to delete at position : "+ postion);
		}
	}

	/* Printing the Linked list stack */
	public void printLinkedList() {
		if (head != null) {
			System.out.println("Printing Linkedlist below : ");
			Node temp = head;
			do {
				System.out.println(temp.value);
				temp = temp.next;
			} while (temp.next != null);
			System.out.println(temp.value);
		} else {
			System.out.println("Linked List is empty!!");
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList duplicate = new SinglyLinkedList();
		duplicate.printLinkedList();
		duplicate.addToLinkedList(1, 5);
		duplicate.addToLinkedList(1, 7);
		duplicate.addToLinkedList(1, 9);
		duplicate.printLinkedList();
		// position starts from 1 onwards
		duplicate.removElementFromParticularPostion(4);
		duplicate.printLinkedList();
	}
}

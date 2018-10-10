package learn.datastructure;

import java.util.Stack;

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
	public int removElementFromParticularPostion(int postion) {
		
		int pos = postion, element = -1;
		if (head == null && pos <= 0)			
			System.out.println("Nothing to empty in Linkedlist!!");

		Node temp = head, prev = null;
		while (temp.next != null && pos != 1) {
			prev= temp;
			temp = temp.next;
			--pos;
		}

		if (temp.next != null && temp.next.next != null && pos == 1) {
			element = head.value;
			head = temp.next;
		} else if(temp.next != null && pos == 1){
			element = prev.next.value;
			prev.next = temp.next;
		}else if(temp.next == null && pos == 1){
			element = temp.value;
			prev.next = null;
		}else {
			System.out.println("Nothing to delete at position : "+ postion);
		}
		
		return element;
	}
	
	/* Search element and return postion */
	public int indexOf(int val) {
		if(head == null)
			return -1;
		
		int index = 1;
		if(head.value == val)
			return index; 
		
		Node temp = head;
		while(temp.next !=null) {
			++index;
			temp = temp.next;
			if(temp.value == val) {
				return index;
			}
		}
		return -1;
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
	
	/* Check Pallindrome using Stack*/
	public boolean checkPallindrome() {
		
		if(head == null)
			return false;
		
		if(head.next == null)
			return true;
		
		Stack<Integer> stack =  new Stack<>();
		Node temp = head;
		
		do {
			stack.push(temp.value);
			temp = temp.next;
		}while(temp != null );
			
		temp = head;
				
		while(temp != null && temp.value == stack.pop()) {
			temp = temp.next;
		}
		
		if(stack.isEmpty())
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		//Initially Empty
		linkedList.printLinkedList();
		// Adding Items
		linkedList.addToLinkedList(1, 5);
		linkedList.addToLinkedList(1, 7);
		linkedList.addToLinkedList(1, 9);
		// Print Linked list
		linkedList.printLinkedList();
		// Position starts from 1 onwards
		System.out.println("Element at position 3 : "+ linkedList.removElementFromParticularPostion(3));
		linkedList.printLinkedList();
		
		// find first index of element
		System.out.println("Index of 9 element "+ linkedList.indexOf(7));
		//Check Palindrome
		linkedList.addToLinkedList(1, 5);
		System.out.println("Checking Pallindrome :"+ linkedList.checkPallindrome());
	}
}

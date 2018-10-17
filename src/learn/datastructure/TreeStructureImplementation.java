package learn.datastructure;

class Node{
	private int value;
	private Node leftTree;
	private Node rightTree;
	
	public Node(int data) {
		value =  data;
		leftTree = null;
		rightTree = null;
	}
	
	public Node(int data, Node left, Node right) {
		value =  data;
		leftTree = left;
		rightTree = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Node leftTree) {
		this.leftTree = leftTree;
	}

	public Node getRightTree() {
		return rightTree;
	}

	public void setRightTree(Node rightTree) {
		this.rightTree = rightTree;
	}
	
	
}
class BinaryTree{
	
	Node root, temp;
	
	public BinaryTree(int rootVal) {
		root = new Node(rootVal);
	}
	
	public Node getRoot(){
		return root;
	}
	
	public void insert(Node node, int data) {
		
		if(node.getValue() > data) {
			if(node.getLeftTree() != null) {
				insert(node.getLeftTree(), data);
			}else {
				node.setLeftTree(new Node(data, null, null));
				return ;
			}			
		}else {
			
			if(node.getRightTree() != null ) {
				insert(node.getRightTree(), data);
			}else {
				node.setRightTree(new Node(data, null, null));
				return ;
			}
		}
	}
	
	public void insertNode(int data) {
		if(root == null ) {
			root = new Node(data);
			return;
		}
		insert(root, data);
	}
	
	// Root - Left - Right
	public void preOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.getValue() + " ");
		preOrderTraversal(node.getLeftTree());
		preOrderTraversal(node.getRightTree());
		
	}
	
	// Left - Root - Right
	public void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		preOrderTraversal(node.getLeftTree());
		System.out.print(node.getValue() + " ");
		preOrderTraversal(node.getRightTree());
	}
	
	// Left - Right - Root
	public void postOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		preOrderTraversal(node.getLeftTree());
		preOrderTraversal(node.getRightTree());
		System.out.print(node.getValue() + " ");
	}
}

public class TreeStructureImplementation {

		public static void main(String[] args) {
			BinaryTree bTree = new BinaryTree(5);
		
			bTree.insertNode(10);
			bTree.insertNode(3);
			bTree.insertNode(4);
			
			System.out.println("Pre-Order Traversal : ");
			bTree.preOrderTraversal(bTree.getRoot());
			
			System.out.println("\nIn-Order Traversal : ");
			bTree.inOrderTraversal(bTree.getRoot());
			
			System.out.println("\nPost-Order Traversal : ");
			bTree.postOrderTraversal(bTree.getRoot());
	}

}

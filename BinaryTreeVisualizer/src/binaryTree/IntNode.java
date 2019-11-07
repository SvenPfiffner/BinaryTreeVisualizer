package binaryTree;

/**
 * An example of an implementation of the TreeNode interface that
 * stores an int value
 * @author Sven Pfiffner | 2019
 */
public class IntNode implements TreeNode, Comparable<IntNode>{
	
	private int value;
	private IntNode leftChild;
	private IntNode rightChild;
	
	public IntNode(int value) {
		this.value = value;
	}
	
	public void setLeftChild(IntNode node) {
		leftChild = node;
	}
	
	public void setRightChild(IntNode node) {
		rightChild = node;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public IntNode getLeft() {
		return leftChild;
	}

	@Override
	public IntNode getRight() {
		return rightChild;
	}

	@Override
	public String stringValue() {
		return Integer.toString(value);
	}

	@Override
	public int compareTo(IntNode o) {
		if(value < o.getValue()) return -1;
		else if(value > o.getValue()) return 1;
		else return 0;
	}
	
	public static IntNode max(IntNode a, IntNode b) {
		if(a.compareTo(b) < 0) return b;
		else return a;
	}

}

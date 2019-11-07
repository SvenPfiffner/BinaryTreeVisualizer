package binaryTree;

import java.util.Random;

/**
 * An example of an implementation of the BinaryTree interface. This
 * tree does not meet any balance-properties, it should only serve as an example
 * @author Sven Pfiffner | 2019
 */
public class SampleTree implements BinaryTree{
	
	private IntNode root;
	
	public SampleTree() {}
	public SampleTree(IntNode node) {this.root = node;}
	
	public void addNode(IntNode node) throws AssertionError{
		if(root == null) {
			root = node;
			return;
		}
		
		IntNode current = root;
		
		while(true) {
			
			if(node.compareTo(current) < 0) {
				if(current.getLeft() == null) {
					current.setLeftChild(node);
					return;
				}
				current = current.getLeft();
			}
			else if(node.compareTo(current) > 0) {
				if(current.getRight() == null) {
					current.setRightChild(node);
					return;
				}
				current = current.getRight();
			}
				
			else
				throw new AssertionError(); //We assume that there can not be more than one note with same value
		}
		
	}
	
	@Override
	public IntNode getRoot() {
		return root;
	}
	
	/**
	 * Builds a binary tree of the natural positive numbers < 10
	 */
	public static SampleTree buildSample() {
		SampleTree sample = new SampleTree();
		
		Random rand = new Random();
		
		for(int i = 0; i<25; i++) {
			try {
				sample.addNode(new IntNode(rand.nextInt(100)));
			} catch (AssertionError e) {}
		}

		return sample;
	}

}

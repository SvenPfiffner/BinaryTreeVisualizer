package binaryTree;

/**
 * An example of an implementation of the BinaryTree interface. This
 * tree does not meet any balance-properties, it should only serve as an example
 * @author Sven Pfiffner | 2019
 */
public class SampleTree implements BinaryTree{
	
	private IntNode root;
	
	public SampleTree() {}
	public SampleTree(IntNode node) {this.root = node;}
	
	public void addNode(IntNode node) {
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
		
		sample.addNode(new IntNode(0));
		
		for(int i = 1; i<100; i++) {
			sample.addNode(new IntNode(100+i));
			sample.addNode(new IntNode(100-i));
		}

		return sample;
	}

}

package graphvizWrapper;
import java.io.File;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;

/**
 * A wrapper class for the GraphViz Java API that allows easy drawing of Binary-Trees
 * that use the BinaryTree interface
 * @author Sven Pfiffner | 2019
 */
public class TreeDrawer {
	
	/*
	 * The location where temporary files should be created and the location of your dot program
	 * TODO: Change this to fit your operating system 
	 */
	public static final String TEMP_DIR = "C:\\Users\\svenp\\AppData\\Local\\Temp";
	public static final String DOT_LOC = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

	/**
	 * Creates an image of the given binary tree and stores it according to the given parameters
	 * 
	 * @param tree: The tree to render
	 * @param filePath: Path of the file to be produced
	 * @param fileName: Name of the file to be produced
	 * @param fileFormat: Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
	 * 
	 * E.g: drawTree(tree, "C:\\Users\\...\\", "myCoolTree", pdf) stores a pdf file of your tree under "C:\Users\...\myCoolTree.pdf"
	 */
	public static void drawTree(BinaryTree tree, String filePath, String fileName, String fileFormat) {
		String dotFormat = treeToDot(tree);
		createDotGraph(dotFormat, filePath, fileName, fileFormat);
	}
	
	/*------------------------------------------
	 * INTERNAL USE ONLY
	 /*-----------------------------------------
	
	/**
	 * Converts a BinaryTree into a dot string.
	 * 
	 * Wrapper function for the recursive treeToDotRec
	 */
	public static String treeToDot(BinaryTree tree) {
		return treeToDotRec(tree.getRoot());
	}
	
	/**
	 * Recursively traverses all nodes in the subtree with the given root
	 */
	private static String treeToDotRec(TreeNode root) {
		
		if(root == null)
			return "";
		
		TreeNode leftChild = root.getLeft();
		TreeNode rightChild = root.getRight();
		String out = "";
		
		if(leftChild != null)
			out += root.stringValue() + "->" + leftChild.stringValue() + ";";
		if(rightChild != null) {
			out += root.stringValue() + "->" + rightChild.stringValue() + ";";
		}
		
		return out + treeToDotRec(leftChild) + treeToDotRec(rightChild);
	}
	
	/**
	 * Create and save a file containing the graph that was given in dot format
	 */
	private static void createDotGraph(String dotFormat, String filePath, String fileName, String type) {
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.add(dotFormat);
		gv.addln(gv.end_graph());
		File out = new File(filePath+fileName+"."+type);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}
	
}

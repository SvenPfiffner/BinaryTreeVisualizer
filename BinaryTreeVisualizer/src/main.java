import binaryTree.SampleTree;
import graphvizWrapper.TreeDrawer;

public class main {

	public static void main(String[] args) {
		
		SampleTree sample = SampleTree.buildSample();
		TreeDrawer.drawTree(sample, "C:\\Users\\svenp\\Desktop\\", "test", "png");
	}

}

# BinaryTreeVisualizer
This Java project serves as an API to the powerful open source graph visualization software Graphviz and lets you render Binary-Trees as graphs and store them as images in various formats (including png, gif, pdf,...).

It relies heavily on the API written by Laszlo Szathmary which i modified to work as easy as possible with Binary-Tree datastructures.

## How to use?
- Download and install Graphviz from https://www.graphviz.org/
- Clone the repository to your machine
- Inside the ```graphvizWrapper``` package, open ```TreeDrawer.java``` and change the final fields

  ```
  public static final String TEMP_DIR = "C:\\Users\\svenp\\AppData\\Local\\Temp";
  public static final String DOT_LOC = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
  ```
  according to your setup. ```TEMP_DIR``` should be the place where you want the program to create temporary files and ```DOT_LOC``` should point to the ```dot.exe``` of the Graphviz software.

- You can now now call

  ```
  TreeDrawer.drawTree(tree, filePath, fileName, fileFormat)
  ```
  for any tree that implements the given BinaryTree interface to store a render of your tree to *filePath/fileName.fileFormat*

## Example
Calling ```TreeDrawer.drawTree()``` on a binary-search-tree over the array ```{0,1,2,3,4,5,6,7,8,9}``` 
renders and stores the following image
![binary-search-tree](link)

For detailed examples refer to 
- ```main.java```  to see how to call drawTree
- ```IntNode.java``` for an implementation of the TreeNode interface
- ```SampleTree.java``` for an implementation of the BinaryTree interface

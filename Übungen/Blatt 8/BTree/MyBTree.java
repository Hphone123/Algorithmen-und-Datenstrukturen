package BTree;

import aud.BTree;
import aud.KTreeNode;
import aud.util.DotViewer;

public class MyBTree<T extends Comparable<T>> extends BTree<T> {

   public MyBTree(int m) {
      super(m);
   }

   public int getHeight() {
      return getHeightFromNode(root()); //* Find Maximum Height Below Root Node 
   }

   public void insertAndViewArray(T [] __data) {
      DotViewer viewer = DotViewer.displayWindow(this, "MyBTree");
      DotViewer.help();
      for (int i = 0; i < __data.length; i++) {
         this.insert(__data[i]);
         viewer.display(this);
      }
   }

   public void insertArray (T [] __data) {
      for (int i = 0; i < __data.length; i++) {
         this.insert(__data[i]);
      }
   }

   //* Recursively Search all Child Nodes to find Maximum Height */
   private int getHeightFromNode (KTreeNode<T> __node) {
      if (__node == null) return 0; //* Node is Empty => Height is 0 */

      int maxHeight = 0; //* Maximum Height Below this Node (for all children)
      for (int i = 0; i < __node.getK(); i++) {
         if (__node.getChild(i) != null) {
            int childHeight = getHeightFromNode(__node.getChild(i));
            if (childHeight > maxHeight) {maxHeight = childHeight;}
         }
      }

      return ++maxHeight; //*return Maximum Height for this Node (Plus this Node)
   }

   public static void main(String [] args) {

      MyBTree<Integer> tree = new MyBTree<Integer>(2);

      tree.insertAndViewArray(new Integer[]{6, 18, 22, 3, 11, 16, 7, 10, 1, 8, 12});

      MyBTree<Integer> biiiiiiigTree = new MyBTree<Integer>(2);
      for (int i = 0; i < 1000000; i++) {
         biiiiiiigTree.insert((int)(Math.random() * 1000000));
      }
      System.out.println(biiiiiiigTree.getHeight());
   }
}

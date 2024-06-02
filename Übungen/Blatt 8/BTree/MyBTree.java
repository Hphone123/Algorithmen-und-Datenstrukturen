package BTree;

import aud.BTree;
import aud.util.DotViewer;

public class MyBTree {

   BTree<Integer> Tree;

   public MyBTree (Integer [] __values) {
      Tree = new BTree<>(2);

      DotViewer Window = DotViewer.displayWindow("Amogus" , "Penis");
      Window.display("null");

      //TODO: Implement
   }

   public int getHeight() {
      //TODO: Implement
      return 0;
   }

   public static void main(String [] args) {
      MyBTree tree = new MyBTree(null);
   }
}

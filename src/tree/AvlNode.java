package tree;

/** Here is the AVL-Node class for Completeness **/
public class AvlNode {
 public AvlNode left;
 public AvlNode right;
 public AvlNode parent;
 public int height;
 public int data;
 public int balance;

 public AvlNode(int k) {
  left = right = parent = null;
  balance = 0;
  height = 0;
  data = k;
 }
 public String toString() {
  return "" + data;
 }

}
// Problem: Lowest common Ancestor(LCA) in a Binary tree. You are given a binary tree and two distinct nodes within the tree. Your task is to find the lowest common ancestor(LCA) of these two nodes.The LCA of two nodes p and q is defined as the lowest node in the tree that has both p and q as descendents(where we will allow a node to be a descendent of itself).
   
//    Input: root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], p = 5, q = 1

//    Output: 3
 

 import java.util.LinkedList;
 import java.util.Queue;

class Tree{
    int val;
    Tree left;
    Tree right;
    Tree(int x){ val = x;}
 }

class Day24{
    public Tree buildTree(Integer[] arr){
      if (arr.length == 0) return null;

      Tree root =  new Tree(arr[0]);
      Queue<Tree> queue = new LinkedList<>();
      queue.offer(root);

      int i =1;
      while (i < arr.length) {
         Tree current = queue.poll();

         if (i < arr.length && arr[i] != null) {
            current.left = new Tree(arr[i]);
            queue.offer(current.left);
         }
         i++;

         if (i < arr.length && arr[i] != null) {
            current.right = new Tree(arr[i]);
            queue.offer(current.right);
         }
         i++;
      }
      return root;
    }

    public Tree findNode(Tree root, int value){
      if (root == null) {
         return null;
      }

      if (root.val == value) {
         return root;
      }

      Tree left = findNode(root.left, value);
      if (left != null) {
         return left;
      }
      return findNode(root.right, value);
    }

    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q){
      if (root == null || root == p || root == q) {
         return root;
      }

      Tree left = lowestCommonAncestor(root.left, p, q);
      Tree right = lowestCommonAncestor(root.right, p, q);

      if (left != null && right != null) {
         return root;
      }

      return left != null ? left : right;
    }

    public static void main(String[] args) {
       Day24 obj = new Day24();

       Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};

       int pVal = 5;
       int qVal = 4;

       Tree root  =obj.buildTree(arr);

       Tree p = obj.findNode(root, pVal);
       Tree q = obj.findNode(root, qVal);

       Tree lca = obj.lowestCommonAncestor(root, p, q);

       System.out.println(lca.val);
    }
 }
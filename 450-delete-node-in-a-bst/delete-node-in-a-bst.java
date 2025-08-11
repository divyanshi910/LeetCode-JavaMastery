/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }
        else{
            //element found
            //case 1 element has only one child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            //case 2 non leaf node
            TreeNode min = findMin(root.right); //inorder successor means find min node in the right side
            root.val = min.val; //swap
            root.right = deleteNode(root.right, min.val);//now deleting the swaped node as we have put the key value on the min value positin
        }
        return root;
    }
    TreeNode findMin(TreeNode node){
        while(node.left!=null){
            node =  node.left;
        }
        return node;
    }
}
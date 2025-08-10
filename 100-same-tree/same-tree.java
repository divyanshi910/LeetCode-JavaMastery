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
 class Pair{
    TreeNode p; //for iteratively
    TreeNode q; //for iteratively
    Pair( TreeNode p, TreeNode q){
        this.p=p;
        this.q=q;
    }
 }
class Solution {
    //recursively approach TC O(N), SC O(N)
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
       boolean left= isSameTree(p.left,q.left);
       boolean right= isSameTree(p.right,q.right);
       return left && right;
    }
    //iteratively TC O(N), SC O(N)
    public boolean isSameTree(TreeNode p, TreeNode q){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(p,q));
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node1 = pair.p;
            TreeNode node2 = pair.q;
            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            stack.push(new Pair(node1.left, node2.left));
            stack.push(new Pair(node1.right, node2.right));
        }
        return true;
    }
}
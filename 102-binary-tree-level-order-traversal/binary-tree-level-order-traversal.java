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
    //TC O(N), SC: O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> bigList= new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         if(root==null){
            return bigList;
         }
         queue.add(root);
         while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> smallList = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode= queue.remove();
                smallList.add(currentNode.val);
                //check for left side
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                //check for right side
                 if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            bigList.add(smallList);
         }
         return bigList;
    }
}
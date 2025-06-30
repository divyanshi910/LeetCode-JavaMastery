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
    public List<Integer> rightSideView(TreeNode root) {
         
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize=queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode currentNode=queue.poll();
                //this is the first node in a queue;
                if(i==queueSize-1){ //only this one gets added 
                    result.add(currentNode.val);
                }
                if(currentNode.left!=null){
                     queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                     queue.add(currentNode.right);
                }
            }
        }
        return result;
    }
}
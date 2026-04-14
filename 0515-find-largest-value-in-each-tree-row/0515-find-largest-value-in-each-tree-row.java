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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
         if(root==null){
            return arr;
        }

        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        while(!qq.isEmpty()){
           List<Integer>ll=new ArrayList<>();
           int size=qq.size();
           for(int i=0;i<size;i++){
            TreeNode curr=qq.poll();
            ll.add(curr.val);
            if(curr.left!=null){
                qq.add(curr.left);
            }if(curr.right!=null){
                qq.add(curr.right);
            }
           }
           ans.add(new ArrayList<>(ll));
        }

        
        for(int i=0;i<ans.size();i++){
            List<Integer>ll=ans.get(i);
            int max=Integer.MIN_VALUE;
            for(int j=0;j<ll.size();j++){
                max=Math.max(max,ll.get(j));
            }
            arr.add(max);
        }
        return arr;
    }
}
package Trees;

public class Question {
    
}
// level order -leetcode-102

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int size=qq.size();
            List<Integer> bw=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                bw.add(curr.val);
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }}
                result.add(bw);
        }
        return result;
    }
}
// post order-leetcode-145

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        helper(root,ll);
        return ll;
        
    }
    public static void helper(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        helper(root.left,ll);
        helper(root.right,ll);
        ll.add(root.val);
    }
}
//pre order

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        helper(root,ll);
        return ll;
        
    }
    public static void helper(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        ll.add(root.val);
        helper(root.left,ll);
        helper(root.right,ll);
    }
}
// max depth of BT

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return Math.max(lh,rh)+1;
    }
}
// count no of nodes-leetcode 222

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lc=countNodes(root.left);
        int rc=countNodes(root.right);
        return lc+rc+1;
    }
}
// brute force for check balance bt

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
      int lh=height(root.left);
      int rh=height(root.right);
        if(lh-rh>1){
            return false;
        }
        if(rh-lh>1){
            return false;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(! left || ! right){
            return false;
        }
        return true;
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
}
// diameter of tree -brute force

class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        max=Math.max(max,lh+rh);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
return max;
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
}
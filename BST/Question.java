package BST;

public class Question {
    
}
// search in BST
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
// ceil in bst
class sol{
public int ceil(Node root,int key){
    int ceil=-1;
    while(root!=null){
        if(root.data==key){
        return root.data;
    }
    if(key>root.data){
        root=root.right;
    }
    else{
        ceil=root.data;
        root=root.left;
    }}
    return ceil;
}
}
// floor in bst
class sol{
    public int floor(Node root,int key){
        int floor=-1;
        while(root!=null){
            if(root.data==key){
                return key;
            }
            if(key<root.data){
                root=root.left;
            }else{
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}
// Inserting Node into BST

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode v=new TreeNode(val);
        if(root==null){
            return v;
        }
        TreeNode curr=root;
        while(true){
            if(curr.val<val){
                if(curr.right!=null){
                    curr=curr.right;
                }else{
                    curr.right=v;
                    break;
                }
            }else{
                if(curr.left!=null){
                    curr=curr.left;
                }else{
                    curr.left=v;
                    break;
                }
            }
        }
       
        return root;
    }
}
// delete a node,there are 2 ways of deleting
// leetcode-450
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    private TreeNode helper(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode rightChild = node.right;
        TreeNode rightMostLeft = findRightMost(node.left);
        rightMostLeft.right = rightChild;

        return node.left;
    }

    private TreeNode findRightMost(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}

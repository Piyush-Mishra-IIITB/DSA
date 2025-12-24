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
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
// kth smallest element in BST

class Solution {
    public int kthSmallest(TreeNode root, int k) {
      List<Integer>ll=new ArrayList<>();
      helper(root,ll);
      int output=0;
      for(int i=1;i<=ll.size();i++){
           output =ll.get(k-1);
      }
      return output;
    }
    public static void helper(TreeNode root,List<Integer>ll){
         if(root==null){
            return;
         }
         helper(root.left,ll);
         ll.add(root.val);
         helper(root.right,ll);
    }
}
// validate a bst

class Solution {
    public boolean isValidBST(TreeNode root) {
        
       return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        public static boolean helper(TreeNode root,long min,long max){
            if(root==null){
                return true;
            }
            if(min>=root.val || root.val>=max){
                return false;
            }
           boolean left=helper(root.left,min,root.val);
           boolean right=helper(root.right,root.val,max);
           if(!left || !right){
            return false;
           }
           return true;
        }
}
// lca in BST

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return helper(root,p,q);
    }
    public static TreeNode helper(TreeNode root,TreeNode a,TreeNode b){
        if(root==null || root==a || root ==b){
            return root;
        }
        int min=Math.min(a.val,b.val);
        int max=Math.max(a.val,b.val);
        if(root.val> max){
           return helper(root.left,a,b);
        }
        if(root.val<min){
           return helper(root.right,a,b);
        }
        return root;
    }
}
// build a bst from preorder
// leetcode-1008
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int inorder[]=preorder.clone();
        Arrays.sort(inorder);
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
              hm.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }
    public static TreeNode helper(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer>hm){
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(preorder[ps]);
        int inroot=hm.get(root.val);
        int numsleft=inroot-is;
        root.left=helper(preorder,ps+1,ps+numsleft,inorder,is,inroot-1,hm);
        root.right=helper(preorder,ps+numsleft+1,pe,inorder,inroot+1,ie,hm);
        return root;
    }
}
// two sum in BST

class Solution {
     static int idx = 0;
    public boolean findTarget(TreeNode root, int k) {
        int length=count(root);
        int arr[]=new int[length];
        idx=0;
        inorder(arr,root);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum=arr[i]+arr[j];
                if(sum==k){
                    return true;
                }
            }
        }
        return false;
    }

public static void inorder(int arr[], TreeNode root){
    if(root == null){
        return;
    }
    inorder(arr, root.left);
    arr[idx++] = root.val;
    inorder(arr, root.right);
}

  public static int count(TreeNode root){
    if(root==null){
        return 0;
    }
   int lh=count(root.left);
   int rh=count(root.right);
   return lh+rh+1;
  }
}

// leetcode-99

class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode mid;
    TreeNode prev;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
                mid=root;
            }else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=last=mid=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if(first!=null && mid!=null){
            int temp=first.val;
            first.val=mid.val;
            mid.val=temp;
        }
    }
}
// largest bst in bt
class Solution {

    static class NodeInfo {
        int min;
        int max;
        int size;

        NodeInfo(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    public static int largestBST(TreeNode root) {
        return helper(root).size;
    }

    private static NodeInfo helper(TreeNode root) {
        if (root == null) {
            return new NodeInfo(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        if (left.max < root.val && root.val < right.min) {

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            int size = left.size + right.size + 1;

            return new NodeInfo(min, max, size);
        }
        return new NodeInfo(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.size, right.size)
        );
    }
}
// creating BST from Inorder only
// leetcode-108
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=helper(arr,start,mid-1);
        root.right=helper(arr,mid+1,end);
        return root; 
    }
}
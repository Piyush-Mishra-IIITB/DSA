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
// best way to compute diameter

class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        diameter=Math.max(lh+rh,diameter);
        return Math.max(lh,rh)+1;
    }
}
// leetcode -124
//max path sum

class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(0,helper(root.left));
        int rightsum=Math.max(0,helper(root.right));
        maxSum=Math.max(leftsum+rightsum+root.val,maxSum);
        return Math.max(leftsum,rightsum)+root.val;
    }
}
// leetcode 100
//same tree

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q !=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left=isSameTree(p.left,q.left);
        boolean right=isSameTree(p.right,q.right);
        if(!left || !right){
            return false;
        }
        return true;
    }
}
// Zig-Zag level order traversal-leetcode 103

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> qq=new LinkedList<>();
        qq.add(root);
        boolean LeftToRight=true;
        while(!qq.isEmpty()){
            int size=qq.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                if(LeftToRight){ll.add(curr.val);}
                else{
                    ll.add(0,curr.val);
                }
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }
            }
            ans.add(ll);
            LeftToRight=!LeftToRight;
        }
    return ans;
    }
}
//Boundary traversal(qood question)
public class Solution {

    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

   //while calling using this order
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }
}
// top view of binary tree
class Solution {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, curr);
            }

            if (curr.left != null) {
                q.offer(new Pair(curr.left, hd - 1));
                min = Math.min(min, hd - 1);
            }

            if (curr.right != null) {
                q.offer(new Pair(curr.right, hd + 1));
                max = Math.max(max, hd + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i).data);
        }

        return ans;
    }
}
// bottom view of Binary tree


class Solution {
    class pair{
        Node node;
        int hr;
        pair(Node node,int hr){
            this.node=node;
            this.hr=hr;
        }
    }
    public List<Integer> bottomView(Node root) {
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<pair>qq=new LinkedList<>();
        HashMap<Integer,Node>hm=new HashMap<>();
        qq.add(new pair(root,0));
        int min=0;
        int max=0;
        while(!qq.isEmpty()){
            pair p=qq.poll();
            Node n=p.node;
            int hr=p.hr;
            
            hm.put(hr,n);
            
            if(n.left!=null){
                qq.add(new pair(n.left,hr-1));
                min=Math.min(min,hr-1);
            }
            if(n.right!=null){
                qq.add(new pair(n.right,hr+1));
                max=Math.max(max,hr+1);
            }
        }
        for(int i=min;i<=max;i++){
            list.add(hm.get(i).data);
        }
        return list;
    }
}
// right view of BT

class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(list,root,0);
        return list;
    }
    public static void helper(List<Integer>list,TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }
        helper(list,root.right,level+1);
        helper(list,root.left,level+1);
    }
}
// leetcode 101

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode a,TreeNode b){
        if(a==null && b!=null){
            return false;
        }
        if(a==null && b==null){
            return true;
        }
        if(a!=null && b==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        boolean left=helper(a.left,b.right);
        boolean right=helper(a.right,b.left);
        if(! left || !right){
            return false;
        }
        return true;
    }
}
//Root to any Node path
class Solution {
    public boolean getPath(TreeNode root, List<Integer> arr, int x) {
        if (root == null) {
            return false;
        }

        arr.add(root.val);

        if (root.val == x) {
            return true;
        }

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }

        arr.remove(arr.size() - 1);
        return false;
    }

    public List<Integer> solve(TreeNode root, int x) {
        List<Integer> arr = new ArrayList<>();

        if (root == null) {
            return arr;
        }

        getPath(root, arr, x);
        return arr;
    }
}
// lowest common ancestor
//leetcode-236

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    
      
    }
}
// max width of bt-leetcode=662

 */
class Solution {
    class pair{
       TreeNode node;
       int index;
       pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
       }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(root,0));
        int maxwidth=0;
        while(!qq.isEmpty()){
            int size=qq.size();
            int minIndex=qq.peek().index;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                pair p=qq.poll();
                TreeNode curr=p.node;
                int currIndex=p.index-minIndex;
                if(i==0){
                    first=currIndex;
                }
                if(i==size-1){
                    last=currIndex;
                }
                if(curr.left !=null){
                    qq.add(new pair(curr.left,2*currIndex+1));
                }
                if(curr.right !=null){
                    qq.add(new pair(curr.right,2*currIndex+2));
                }
           
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;
    }
}
// leetcode 863
//Nodes At K Distance

 */class Solution {
    public static void markParent(TreeNode root, HashMap<TreeNode, TreeNode> hm) {
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);

        while (!qq.isEmpty()) {
            TreeNode curr = qq.poll();

            if (curr.left != null) {
                hm.put(curr.left, curr);
                qq.add(curr.left);
            }
            if (curr.right != null) {
                hm.put(curr.right, curr);
                qq.add(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        Queue<TreeNode> qq = new LinkedList<>();
        HashMap<TreeNode, Boolean> vis = new HashMap<>();

        qq.add(target);
        vis.put(target, true); 

        int currdis = 0;

        while (!qq.isEmpty()) {
            int size = qq.size();
            if (currdis == k) break;

            currdis++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = qq.poll();

                if (curr.left != null && !vis.containsKey(curr.left)) {
                    vis.put(curr.left, true);
                    qq.add(curr.left);
                }

                if (curr.right != null && !vis.containsKey(curr.right)) {
                    vis.put(curr.right, true);
                    qq.add(curr.right);
                }

                TreeNode par = parent.get(curr);
                if (par != null && !vis.containsKey(par)) {
                    vis.put(par, true);
                    qq.add(par);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!qq.isEmpty()) {
            ans.add(qq.poll().val);
        }

        return ans;
    }
}
//min time taken too burn a BT from a Node
class Solution {

    public static void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public int distanceK(TreeNode root, TreeNode target) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> vis = new HashMap<>();

        q.add(target);
        vis.put(target, true);

        int distance = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !vis.containsKey(curr.left)) {
                    vis.put(curr.left, true);
                    q.add(curr.left);
                }

                if (curr.right != null && !vis.containsKey(curr.right)) {
                    vis.put(curr.right, true);
                    q.add(curr.right);
                }

                TreeNode par = parent.get(curr);
                if (par != null && !vis.containsKey(par)) {
                    vis.put(par, true);
                    q.add(par);
                }
            }
        }

        return distance;
    }
}
// leetcode -222

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
//leetcode -105
// BT from inorder and preorder

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
        hm.put(inorder[i],i);
        }
      return  build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
        
    }
    public TreeNode build(int[] preorder,int ps,int pe, int[] inorder,int is,int ie,HashMap<Integer,Integer>hm){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode root=new TreeNode(preorder[ps]);
        int inroot=hm.get(root.val);
        int numsleft=inroot-is;
        root.left=build(preorder,ps+1,ps+numsleft,inorder,is,inroot-1,hm);
        root.right=build(preorder,ps+numsleft+1,pe,inorder,inroot+1,ie,hm);
        return root;

    }
}
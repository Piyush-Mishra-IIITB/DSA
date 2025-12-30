package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Graph.Questions.Pair;

public class Questions {
    
}
// BFS
public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
    List<Integer> ans = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    boolean[] vis = new boolean[V];
    vis[0] = true;

    while (!q.isEmpty()) {
        int node = q.poll();
        ans.add(node);

        List<Integer> neighbors = adj.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            int it = neighbors.get(i);
            if (!vis[it]) {
                vis[it] = true;
                q.add(it);
            }
        }
    }

    return ans;
}
// dfs
public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
    List<Integer> dfs = new ArrayList<>();
    boolean[] vis = new boolean[V];

    dfsHelper(0, adj, vis, dfs);
    return dfs;
}

private void dfsHelper(int node, List<List<Integer>> adj,
                       boolean[] vis, List<Integer> dfs) {

    vis[node] = true;
    dfs.add(node);

    List<Integer> neighbors = adj.get(node);
    for (int i = 0; i < neighbors.size(); i++) {
        int it = neighbors.get(i);
        if (!vis[it]) {
            dfsHelper(it, adj, vis, dfs);
        }
    }
}

// number of provinces
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private void bfs(int start, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}
// flood fill algo
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initC=image[sr][sc];
        if (initC == color) return image;
       return helper(sr,sc,initC,image,color);
    }
    public int[][] helper(int sr,int sc,int initC,int image[][],int nC){
        image[sr][sc]=nC;
        int n=image.length;
        int m=image[0].length;
        if(sr+1<n && image[sr+1][sc]==initC){
            helper(sr+1,sc,initC,image,nC);
        }if(sr-1>=0 && image[sr-1][sc]==initC){
            helper(sr-1,sc,initC,image,nC);
        }if(sc+1<m && image[sr][sc+1]==initC){
            helper(sr,sc+1,initC,image,nC);
        }
        if(sc-1>=0 && image[sr][sc-1]==initC){
            helper(sr,sc-1,initC,image,nC);
        }
        return image;
    }
}
// rotten oranges
// leetcode-994

class pair{
    int row;
    int col;
    int tm;
    pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }}
    class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair>qq=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int counterfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qq.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    counterfresh++;
                }
            }
        }
        int timer=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int counter=0;
        while(!qq.isEmpty()){
            int r=qq.peek().row;
            int c=qq.peek().col;
            int t=qq.peek().tm;
            timer=Math.max(timer,t);
            qq.poll();
          for(int i=0;i<4;i++){
            int newRow=r+drow[i];
            int newCol=c+dcol[i];
            if(newRow>=0 &&newRow<n &&newCol>=0 &&newCol<m&& grid[newRow][newCol]==1&& vis[newRow][newCol]==0){
                qq.add(new pair(newRow,newCol,t+1));
                vis[newRow][newCol]=2;
                counter++;
            }
          }
        }
        if(counter!=counterfresh){
            return -1;
        }else{
            return timer;
        }
    }
}
// detect cycle using bfs in undirected graph
class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int src, List<Integer>[] adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int node = cur.node;
            int parent = cur.parent;

            for (int adjNode : adj[node]) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                }
                else if (adjNode != parent) {
                    return true;  
                }
            }
        }
        return false;
    }
}
// cycle detection using dfs
class Solution {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (detectCycle(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int node, int parent,
                                ArrayList<ArrayList<Integer>> adj,
                                int[] vis) {

        vis[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (detectCycle(neighbor, node, adj, vis)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}

// leetcode 542

class pair{
    int row;
    int col;
    int near;
    pair(int row,int col,int near){
        this.row=row;
        this.col=col;
        this.near=near;
    }
    
}
 class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
    Queue<pair>qq=new LinkedList<>();
    int vis[][]=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            vis[i][j]=0;
        }
    }
    int dist[][]=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(mat[i][j]==0){
                qq.add(new pair(i,j,0));
                vis[i][j]=1;
            }
        }
    }
    int ar[]={-1,0,1,0};
    int ac[]={0,1,0,-1};
    while(!qq.isEmpty()){
        int crow=qq.peek().row;
        int ccol=qq.peek().col;
        int cdis=qq.peek().near;
        dist[crow][ccol]=cdis;
        qq.poll();
        for(int i=0;i<4;i++){
            int newRow=crow+ar[i];
            int newCol=ccol+ac[i];
            if(newRow>=0 && newRow<n &&newCol>=0 && newCol<m && vis[newRow][newCol]==0){
                vis[newRow][newCol]=1;
                qq.add(new pair(newRow,newCol,cdis+1));
            }
        }
    }
return dist;
    }
}
// leetcode 130
// surrounded region
class Solution {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(0, j, board, vis);
            }
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                dfs(n - 1, j, board, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, board, vis);
            }
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(i, m - 1, board, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m ||
            board[r][c] == 'X' || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        dfs(r + 1, c, board, vis);
        dfs(r - 1, c, board, vis);
        dfs(r, c + 1, board, vis);
        dfs(r, c - 1, board, vis);
    }
}
// leetcode -1020
//number of enclaves
class pair{
    int row;
    int col;
    pair(int row,int col){
      this.row=row;
      this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][0]==1&& vis[i][0]==0){
                    bfs(i,0,vis,grid);
                }
                if(grid[i][m-1]==1&& vis[i][m-1]==0){
                    bfs(i,m-1,vis,grid);
                }
                if(grid[0][j]==1&& vis[0][j]==0){
                    bfs(0,j,vis,grid);
                }if(grid[n-1][j]==1&& vis[n-1][j]==0){
                    bfs(n-1,j,vis,grid);
                }
            }
        }
        int output=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]==1){
                    output++;
                }
            }
        }
        return output;
    }
    public void bfs(int row,int col,int vis[][],int grid[][]){
        Queue<pair>qq=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        qq.add(new pair(row,col));
        vis[row][col]=1;
        int rc[]={-1,0,1,0};
        int cc[]={0,1,0,-1};
        while(!qq.isEmpty()){
               int crow=qq.peek().row;
               int ccow=qq.peek().col;
               qq.poll();
               for(int i=0;i<4;i++){
                int newRow=crow+rc[i];
                int newColl=ccow+cc[i];
                if(newRow>=0&&newRow<n&&newColl>=0&&newColl<m&&vis[newRow][newColl]==0&&grid[newRow][newColl]==1){
                    qq.add(new pair(newRow,newColl));
                    vis[newRow][newColl]=1;
                }
               }
        }
    }
}
// numer of island
// leetcode-200
class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == '1' &&
                    vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
// no. of distict island
class Solution {

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, grid, vis, shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int r, int c, int br, int bc,
                     int[][] grid, boolean[][] vis,
                     List<String> shape) {

        vis[r][c] = true;
        shape.add((r - br) + "," + (c - bc));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < grid.length &&
                nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] == 1 && !vis[nr][nc]) {

                dfs(nr, nc, br, bc, grid, vis, shape);
            }
        }
    }
}
// Bipartite graph using bfs

class Solution {
    public boolean isBipartite(int[][] graph) {
      int n=graph.length;
       int vis[]=new int[n];
       for(int i=0;i<n;i++){
            vis[i]=-1;
       }
       for(int i=0;i<n;i++){
        if(vis[i]==-1){
            if(bfs(i,vis,graph)==false){
                return false;
            }
        }
       }
       return true;
    }
    public boolean bfs(int start,int vis[],int graph[][]){
        Queue<Integer>qq=new LinkedList<>();
        qq.add(start);
        vis[start]=1;
        while(!qq.isEmpty()){
            int node=qq.peek();
            qq.poll();
            for(int adj:graph[node]){
                if(vis[adj]==-1){
                    vis[adj]=1-vis[node];
                    qq.add(adj);
                }
                else if(vis[adj]==vis[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
// cycle detection using dfs in directed graph
class Solution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] vis = new int[N];
        int[] pathvis = new int[N];

        for (int i = 0; i < N; i++) {
            vis[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            if (vis[i] == -1) {
                if (dfs(i, adj, vis, pathvis)) {
                    return true; 
                }
            }
        }
        return false; 
    }

    public boolean dfs(int node, List<List<Integer>> adj,
                       int[] vis, int[] pathvis) {

        vis[node] = 1;
        pathvis[node] = 1;

        for (int ad : adj.get(node)) {

            if (vis[ad] == -1) {
                if (dfs(ad, adj, vis, pathvis)) {
                    return true;
                }
            }
            else if (pathvis[ad] == 1) {
                return true; 
            }
        }

        pathvis[node] = 0;
        return false;
    }
}
//Eventual Safe States leetcode -802

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int pathvis[]=new int[n];
        int safe[]=new int[n];
        for(int i=0;i<n;i++){
            vis[i]=0;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,pathvis,safe,graph);
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int start,int vis[],int pathvis[],int safe[],int[][] graph){
        vis[start]=1;
        pathvis[start]=1;
        safe[start]=0;
        for(int ad:graph[start]){
             if(vis[ad]==0){
                if(dfs(ad,vis,pathvis,safe,graph)==true){
                    return true;
                }
             }
             else if(pathvis[ad]==1){
                return true;
             }
        }
        safe[start]=1;
        pathvis[start]=0;
        return false;
    }
}
// topo sort
class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] vis = new int[V];
        Stack<Integer> ss = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, ss, adj);
            }
        }

        int[] arr = new int[V];
        int index = 0;

        while (!ss.isEmpty()) {
            arr[index++] = ss.pop();
        }

        return arr;
    }

    public static void dfs(int start, int[] vis,
                           Stack<Integer> ss,
                           List<List<Integer>> adj) {

        vis[start] = 1;

        for (int ad : adj.get(start)) {
            if (vis[ad] == 0) {
                dfs(ad, vis, ss, adj);
            }
        }

        ss.push(start);
    }
}
// kahn's algo
//topo with bfs
class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] ind = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                ind[it]++;
            }
        }
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (ind[i] == 0) {
                qq.add(i);
            }
        }
        int[] topo = new int[V];
        int index = 0;

        while (!qq.isEmpty()) {
            int node = qq.poll();
            topo[index++] = node;

            for (int it : adj.get(node)) {
                ind[it]--;
                if (ind[it] == 0) {
                    qq.add(it);
                }
            }
        }

        return topo;
    }
}

// detectinf a cycle in Directed cyclic graph
//using khan's algo
class Solution {
    public boolean isCyclic(int n, List<List<Integer>> adj) {
      int ind[]=new int[n];
      for(int i=0;i<n;i++){
        for(int it:adj.get(i)){
          ind[it]++;
        }
      }
      Queue<Integer>qq=new LinkedList<>();
      for(int i=0;i<n;i++){
        if(ind[i]==0){
          qq.add(i);
        }
      }
      List<Integer>ll=new ArrayList<>();
      while(!qq.isEmpty()){
        int node=qq.poll();
           ll.add(node);
           for(int it:adj.get(node)){
            ind[it]--;
            if(ind[it]==0){
              qq.add(it);
            }        
        }
      }
      if(ll.size()==n){
        return false;
      }
      else{
        return true;
      }
    }
}
// Course Schedule-1 leetcode 207

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            adj.get(pre).add(course);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return count == n;
    }
}
// course schedule -2
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            adj.get(pre).add(course);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[idx++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (idx != n) {
            return new int[0];
        }

        return topo;
    }
}
// Alien Dictionary

class Solution {
    public String findOrder(String[] dict, int n, int k) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String a = dict[i];
            String b = dict[i + 1];

            int len = Math.min(a.length(), b.length());

            for (int pt = 0; pt < len; pt++) {
                if (a.charAt(pt) != b.charAt(pt)) {
                    adj.get(a.charAt(pt) - 'a')
                       .add(b.charAt(pt) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoOrder = topo(k, adj);

        StringBuilder ans = new StringBuilder();
        for (int i : topoOrder) {
            ans.append((char) (i + 'a'));
        }

        return ans.toString();
    }

    public List<Integer> topo(int v, List<List<Integer>> adj) {
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return ans;
    }
}


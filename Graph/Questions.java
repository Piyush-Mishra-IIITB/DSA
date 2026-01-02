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
// shortest path in DAG
import java.util.*;

class Pair {
    int val;
    int wt;
    Pair(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
}

class Solution {
    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.wt < dist[it.val]) {
                        dist[it.val] = dist[node] + it.wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public void dfs(int node, int[] vis, Stack<Integer> st, List<List<Pair>> adj) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            if (vis[it.val] == 0) {
                dfs(it.val, vis, st, adj);
            }
        }
        st.push(node);
    }
}
// dijkstra's algorithm
class pair {
    int first;   // distance
    int second;  // node

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        PriorityQueue<pair> pq =
            new PriorityQueue<>((a, b) -> a.first - b.first);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new pair(0, S));

        while (!pq.isEmpty()) {

            pair p = pq.poll();
            int dis = p.first;
            int node = p.second;

            for (ArrayList<Integer> it : adj.get(node)) {

                int adjNode = it.get(0);
                int wt = it.get(1);

                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    pq.add(new pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
// using set

class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        TreeSet<pair> set = new TreeSet<>(
            (a, b) -> a.first != b.first ? a.first - b.first : a.second - b.second
        );

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        set.add(new pair(0, S));

        while (!set.isEmpty()) {

            pair p = set.pollFirst();  
            int dis = p.first;
            int node = p.second;

            for (ArrayList<Integer> it : adj.get(node)) {

                int adjNode = it.get(0);
                int wt = it.get(1);

                if (dis + wt < dist[adjNode]) {
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new pair(dist[adjNode], adjNode));
                    }

                    dist[adjNode] = dis + wt;
                    set.add(new pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

// shortest path
class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<Integer> dijkstra(
            int V,
            ArrayList<ArrayList<ArrayList<Integer>>> adj,
            int S,
            int D) {

        PriorityQueue<pair> pq =
            new PriorityQueue<>((a, b) -> a.first - b.first);

        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        dist[S] = 0;
        pq.add(new pair(0, S));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int dis = curr.first;
            int node = curr.second;

            if (dis > dist[node]) continue;

            for (ArrayList<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int wt = it.get(1);

                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    parent[adjNode] = node;
                    pq.add(new pair(dist[adjNode], adjNode));
                }
            }
        }

        if (dist[D] == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int node = D;

        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }

        ans.add(S);
        Collections.reverse(ans);
        return ans;
    }
}
// shortest distance in a binary maze
class pair {
    int dis;
    int row;
    int col;

    pair(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<pair> qq = new LinkedList<>();
        qq.add(new pair(1, 0, 0));
        dist[0][0] = 1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!qq.isEmpty()) {
            pair curr = qq.poll();
            int dis = curr.dis;
            int r = curr.row;
            int c = curr.col;

            if (r == n - 1 && c == n - 1) return dis;

            for (int i = 0; i < 8; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newc >= 0 && newr < n && newc < n
                        && grid[newr][newc] == 0
                        && dis + 1 < dist[newr][newc]) {

                    dist[newr][newc] = dis + 1;
                    qq.add(new pair(dis + 1, newr, newc));
                }
            }
        }
        return -1;
    }
}
// path with min effort

class pair{
    int dif;
    int row;
    int col;
    pair(int dif,int row,int col){
        this.dif=dif;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int diff[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            diff[i][j]=Integer.MAX_VALUE;
        }}
        diff[0][0]=0;
        PriorityQueue<pair>qq=new PriorityQueue<>((a,b)->a.dif-b.dif);
        qq.add(new pair(0,0,0));
        int dr[]={1,0,-1,0};
        int dc[]={0,-1,0,1};
        while(!qq.isEmpty()){
            pair node=qq.poll();
            int d=node.dif;
            int r=node.row;
            int c=node.col;
            if(r==n-1 && c==m-1){
                return d;
            }
            if(d>diff[r][c]){
                continue;
            }
            for(int i=0;i<4;i++){
               int nr=r+dr[i];
               int nc=c+dc[i];
               if(nr>=0&&nc>=0&&nc<m&&nr<n){
                int effort=Math.max(d,Math.abs(arr[nr][nc]-arr[r][c]));
                if(effort<diff[nr][nc]){
                    diff[nr][nc]=effort;
                    qq.add(new pair(effort,nr,nc));
                }
               }
            }
        }
        return 0;
    }
}
// Cheapest Flights Within K Stops

class pair{
    int stop;
    int node;
    int dis;
    pair(int stop,int node,int dis){
        this.stop=stop;
        this.node=node;
        this.dis=dis;
    }
}
class dup{
    int rou;
    int di;
    dup(int rou,int di){
        this.rou=rou;
        this.di=di;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<dup>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int a=flights[i][0];
            int b=flights[i][1];
            int c=flights[i][2];
            adj.get(a).add(new dup (b,c));
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.stop-b.stop);
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[src]=0;
        pq.add(new pair(0,src,0));
        while(!pq.isEmpty()){
           pair p=pq.poll();
           int s=p.stop;
           int no=p.node;
           int d=p.dis;
           if(s>k){
            continue;
           }
           for(dup it:adj.get(no)){
            int rou=it.rou;
            int di=it.di;
           if(d+di<dis[rou]&& s<=k){
            dis[rou]=d+di;
            pq.add(new pair(s+1,rou,dis[rou]));
           }
           }
        }
        if(dis[dst]==Integer.MAX_VALUE){
        return -1;
       }
       return dis[dst];
    }
}
// leetcode-1976
// Number of Ways to Arrive at Destination
class pair {
    long dist;
    int node;

    pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class ad {
    int to;
    int wt;

    ad(int to, int wt) {
        this.to = to;
        this.wt = wt;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        ArrayList<ArrayList<ad>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new ad(v, w));
            adj.get(v).add(new ad(u, w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.add(new pair(0, 0));

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            long d = p.dist;
            int u = p.node;

            if (d > dist[u]) continue;

            for (ad it : adj.get(u)) {
                int v = it.to;
                int wt = it.wt;

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    ways[v] = ways[u];
                    pq.add(new pair(dist[v], v));
                } else if (d + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}
// network delay time
class pair {
    int target;
    int time;

    pair(int target, int time) {
        this.target = target;
        this.time = time;
    }
}

class dou {
    int dist;
    int node;

    dou(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0] - 1;
            int v = times[i][1] - 1;
            int w = times[i][2];
            adj.get(u).add(new pair(v, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<dou> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[k - 1] = 0;
        pq.add(new dou(0, k - 1));

        while (!pq.isEmpty()) {
            dou curr = pq.poll();
            int d = curr.dist;
            int node = curr.node;

            if (d > dist[node]) continue;

            for (pair it : adj.get(node)) {
                int next = it.target;
                int wt = it.time;

                if (d + wt < dist[next]) {
                    dist[next] = d + wt;
                    pq.add(new dou(dist[next], next));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
// bell man ford algo
class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edge,
                              int S) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edge) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (ArrayList<Integer> it : edge) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
//Floyd warshall algorithm
class Solution {
    public void shortestDistance(int[][] matrix) {
        int n=matrix.length;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==-1){
                matrix[i][j]=Integer.MAX_VALUE;
            }
            if(i==j){
                matrix[i][j]=0;
            }
        }
    }
    for(int via=0;via<n;via++){
        for(int i=0;i<n;i++){
            if(matrix[i][via]==Integer.MAX_VALUE){
                continue;
            }
            for(int j=0;j<n;j++){
                if(matrix[via][j]==Integer.MAX_VALUE){
                    continue;
                }
                matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
            }
        }
    }
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==Integer.MAX_VALUE){
                matrix[i][j]=-1;
            }
        }
    }
    }
}
//  Find the City With the Smallest Number of Neighbors 
// at a Threshold Distance -leetcode 1334

class Solution {
    public int findTheCity(int n, int[][] edge, int thres) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
                if(i==j){
                    dist[i][j]=0;
                }
            }
        }
        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int wt=edge[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(dist[i][k]==Integer.MAX_VALUE){
                    continue;
                }
                for(int j=0;j<n;j++){
                    if(dist[k][j]==Integer.MAX_VALUE){
                    continue;
                }
                dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
                }
            }
        int minCount = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= thres) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
        }
    }
// prim's algorithm
class tuple {
    int wt;
    int node;
    int paren;
    tuple(int wt, int node, int paren) {
        this.wt = wt;
        this.node = node;
        this.paren = paren;
    }
}

class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int spanningTree(int n, List<List<List<Integer>>> adj) {

        PriorityQueue<tuple> pq =
            new PriorityQueue<>((a, b) -> a.wt - b.wt);

        int[] vis = new int[n];
        int sum = 0;
        List<pair> ll = new ArrayList<>();

        pq.add(new tuple(0, 0, -1));

        while (!pq.isEmpty()) {
            tuple curr = pq.poll();
            int w = curr.wt;
            int u = curr.node;
            int parent = curr.paren;

            if (vis[u] == 1) continue;

            vis[u] = 1;
            sum += w;

            if (parent != -1) {
                ll.add(new pair(u, parent));
            }
            for (List<Integer> it : adj.get(u)) {
                int v = it.get(0);
                int wt = it.get(1);

                if (vis[v] == 0) {
                    pq.add(new tuple(wt, v, u));
                }
            }
        }

        return sum;
    }
}
// kruskal's algo
class Edge {
    int u, v, wt;
    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); 
        return parent[x];
    }

    boolean sameParent(int u, int v) {
        return find(u) == find(v);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

class Solution {
    public int spanningTree(int V, int E, int[][] edges) {
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            list.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
        Collections.sort(list, (a, b) -> a.wt - b.wt);

        DSU dsu = new DSU(V);

        int mstWeight = 0;
        int edgeCount = 0;

        for (Edge e : list) {
            if (!dsu.sameParent(e.u, e.v)) {
                mstWeight += e.wt;
                dsu.union(e.u, e.v);
                edgeCount++;
            }

            if (edgeCount == V - 1)
                break;
        }

        return mstWeight;
    }
}
// Number of Operations to Make Network Connected
class Solution {

    class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return false;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int[] edge : connections) {
            if (!ds.union(edge[0], edge[1])) {
                extraEdges++;
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) {
                components++;
            }
        }

        if (extraEdges >= components - 1) {
            return components - 1;
        }

        return -1;
    }
}
// making a large island
import java.util.*;

class DSU {
    int[] parent, size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    int getSize(int x) {
        return size[find(x)];
    }
}

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int id1 = i * n + j;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n &&
                                grid[ni][nj] == 1) {
                            int id2 = ni * n + nj;
                            dsu.union(id1, id2);
                        }
                    }
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n * n; i++) {
            if (grid[i / n][i % n] == 1) {
                maxArea = Math.max(maxArea, dsu.getSize(i));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> parents = new HashSet<>();
                    int area = 1;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n &&
                                grid[ni][nj] == 1) {
                            int parent = dsu.find(ni * n + nj);
                            if (parents.add(parent)) {
                                area += dsu.size[parent];
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
// DSU
import java.util.*;
class DisJSet{
    List<Integer>parent=new ArrayList<>();
    List<Integer>rank=new ArrayList<>();
    DisJSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
       int uper=findUpar(parent.get(node));
       parent.set(node,uper);
       return parent.get(node);
    }
    public void UnionByRank(int u,int v){
        int pu=findUpar(u);
        int pv=findUpar(v);
        if(pu==pv){
            return;
        }
        if(rank.get(pu)>rank.get(pv)){
            parent.set(pv,pu);
        }
       else if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }
        else{
            parent.set(pu,pv);
            int r=rank.get(pv);
            rank.set(pv,r+1);
        }
    }
}
class Main {
    public static void main(String[] args) {
        DisJSet ss=new DisJSet(5);
        ss.UnionByRank(3,4);
        ss.UnionByRank(2,3);
        ss.UnionByRank(1,2);
       System.out.print(ss.findUpar(1));
    }
}
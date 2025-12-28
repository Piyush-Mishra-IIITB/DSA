package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

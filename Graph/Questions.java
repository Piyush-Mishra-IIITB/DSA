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


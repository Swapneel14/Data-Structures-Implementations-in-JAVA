class Solution {
    boolean[]visited;
    ArrayList<ArrayList<Integer>> adj;
    
    
    private boolean cycle_DFS(int u,int parent,int V,ArrayList<ArrayList<Integer>> adj){
        visited[u]=true;
        
        
        for(int v:adj.get(u)){
           
                if(v==parent)continue;
            
            if(visited[v])return true;
            
            if(cycle_DFS(v,u,V,adj))return true;
           
        }
        
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        visited= new boolean[V];
        adj = new ArrayList<>();
        
         for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i = 0 ; i < V ; i ++){
            if(!visited[i]&&cycle_DFS(i,-1,V,adj))return true;
        }
        
        return false;
        
    }
}

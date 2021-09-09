
// Leetcode Problem: Connecting Cities With Minimum Cost...

// Kruskal MST Application..
// Union Find + Path Compression(parent->grandParent Connection in find) + Weighted Union(In Union).
class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf=new UnionFind(n+1);
        int totalEdges=0;
        int cost=0;
        Arrays.sort(connections,(c1,c2) -> (c1[2]-c2[2]));
        
        for(int[] connection : connections){
            int a=connection[0];
            int b=connection[1];
            if(uf.isSameGroup(a,b)){
                continue;
            }
            uf.union(a,b);
            cost+=connection[2];
            totalEdges++;
        }
        
        if(totalEdges==n-1){
            return cost;
        }
        return -1;
        
    }
    class UnionFind{
        private int[] parent;
        private int[] weight;
        
        public UnionFind(int n){
            parent=new int[n+1];
            weight=new int[n+1];
            for(int i=1;i<n+1;i++){
                parent[i]=i;
                weight[i]=1;
            }
        }
        
        public int find(int node){
            while(node!=parent[node]){
                // Path Compression...
                parent[node]=parent[parent[node]];
                node=parent[node];
            }
            return node;
        }
        
        public void union(int p,int q){
            int parent1=find(p);
            int parent2=find(q);
            if(parent1==parent2){
                return;
            }
            // Weighted Union...
            if(weight[parent1]>weight[parent2]){
                parent[parent2]=parent1;
                weight[parent1]+=weight[parent2];
            }else{
                parent[parent1]=parent2;
                weight[parent2]+=weight[parent1];
            }
        }
        
        public boolean isSameGroup(int p,int q){
            return find(p)==find(q);
        }
        
    }
}
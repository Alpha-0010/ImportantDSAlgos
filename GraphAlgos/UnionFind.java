
// Leetcode: Number Of Provinces...

/* ....Application of UnionFind.... */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}

class UnionFind{
    private int count;
    private int[] parent;
    
    public UnionFind(int n){
        count=n;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    
    public int find(int node){
        while(node!=parent[node]){
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
        parent[parent2]=parent1;
        count--;
    }
    
    public int count(){
        return count;
    }
}
// Based on UnionFind Algo...
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length!=n-1){
            return false;
        }
        
        UnionFind uf=new UnionFind(n);
        
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            if(uf.isConnected(x,y)){
                return false;
            }
            uf.union(x,y);
        }
        return true;
    }
}

class UnionFind{
    private int[] root;
    private int[] rank;
    private int count;
    
    public UnionFind(int n){
        root=new int[n];
        rank=new int[n];
        count=n;
        for(int i=0;i<n;i++){
            root[i]=i;
            rank[i]=1;
        }
    }
    
    public int find(int x){
        if(x==root[x]){
            return x;
        }
        return find(root[x]);
    }
    
    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY){
            return;
        }
        if(rank[rootY]<rank[rootX]){
            root[rootY]=rootX;
        }else if(rank[rootX]<rank[rootY]){
            root[rootX]=rootY;
        }else{
            root[rootY]=rootX;
            rank[rootX]++;
        }
        count--;
    }
    
    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }
    
    public int count(){
        return count;
    }
    
}
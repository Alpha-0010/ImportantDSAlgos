// UnionFind Application with Union by Rank and Path Compression...
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
    private int[] root;
    private int[] rank;
    private int count;
    
    public UnionFind(int n){
        count=n;
        root=new int[n];
        rank=new int[n];
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
        if(rank[rootX]>rank[rootY]){
            root[rootY]=rootX;
        }else if(rank[rootX]<rank[rootY]){
            root[rootX]=rootY;
        }else{
            root[rootY]=rootX;
            rank[rootX]++;
        }
        count--;
    }
    
    public boolean connected(int x,int y){
        return find(x)==find(y);
    }
    
    public int count(){
        return count;
    }
    
}
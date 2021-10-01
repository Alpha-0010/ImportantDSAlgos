class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort( logs,(l1,l2) -> (l1[0]-l2[0]) );
        
        UnionFind uf=new UnionFind(n);
        
        for(int[] log : logs){
            int x=log[1];
            int y=log[2];
            uf.union(x,y);
            if(uf.count()==1){
                return log[0];
            }
        }
        
        return -1;
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
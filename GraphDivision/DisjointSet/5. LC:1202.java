/*

https://leetcode.com/problems/smallest-string-with-swaps/discuss/388055/Java-Union-find-%2B-PriorityQueue.-Easy-to-understand.

.......UnionFind + PriorityQueue......

*/
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        UnionFind uf=new UnionFind(n);
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        
        for(List<Integer> pair : pairs){
            int x=pair.get(0);
            int y=pair.get(1);
            uf.union(x,y);
        }
        
        for(int i=0;i<n;i++){
            int root=uf.find(i);
            if(!map.containsKey(root)){
                map.put(root,new PriorityQueue<>());
            }
            map.get(root).add(s.charAt(i));
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int root=uf.find(i);
            sb.append(map.get(root).poll());
        }
        
        return sb.toString();
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
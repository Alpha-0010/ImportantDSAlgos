
// Leetcode Problem: Word Ladder...

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Shortest path BFS...
        Set<String> set=new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);
        
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        
        while(queue.size()!=0){
            int len=queue.size();
            
            for(int i=0;i<len;i++){
                String str=queue.poll();
                if(str.equals(endWord)){
                    return level;
                }
                for(String neighbor : neighbors(str,set)){
                    queue.add(neighbor);
                }
            }
            level++;
        }
        return 0;
    }
    
    private List<String> neighbors(String str,Set<String> set){
        List<String> res=new ArrayList<>();
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c1=arr[i];
            for(char j='a';j<='z';j++){
                arr[i]=j;
                String word=new String(arr);
                if(set.contains(word)){
                    set.remove(word);
                    res.add(word);
                }
            }
            arr[i]=c1;
        }
        return res;
    }
    
}
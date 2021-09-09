
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort on the basis of ascending order and check for overlaps...
        Arrays.sort(intervals, (I1,I2) -> (I1[0]-I2[0]));
        
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        
        return true;
    }
}
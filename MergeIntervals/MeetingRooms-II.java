
// Heap based solution...
// Refer solution article for better explanation...

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length==0){
            return 0;
        }

        // Sort the intervals in the ascending order of start time...
        Arrays.sort(intervals, (I1,I2) -> (I1[0]-I2[0]));

        // Use a MinHeap on ending time so that the interval which ends at the earliest will stay on
        // top. And if an interval can't be merged with the earliest ending interval then definitely it
        // should be assigned a seperate conference room...

        PriorityQueue<Integer> conferenceRoom=new PriorityQueue<Integer>( (a,b) -> (a-b));

        conferenceRoom.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            // Merge ith interval with earliest ending interval if there is no overlap...
            if(intervals[i][0]>=conferenceRoom.peek()){
                conferenceRoom.poll();
            }
            conferenceRoom.add(intervals[i][1]);
        }
        return conferenceRoom.size();
    }
}
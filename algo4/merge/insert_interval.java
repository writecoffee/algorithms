import java.util.ArrayList;


public class insert_interval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int N = intervals.size();
        int i = 0;
        
        while (i < N) {
            Interval temp = intervals.get(i);
            
            if (temp.end < newInterval.start) {
                result.add(temp);
            } else if (temp.start > newInterval.end) {
                break;
            } else {
                newInterval.start = Math.min(temp.start, newInterval.start);
                newInterval.end = Math.max(temp.end, newInterval.end);
            }
 
            ++i;
        }
        
        result.add(newInterval);
        
        while (i < N) {
            result.add(intervals.get(i));
            i++;
        }
        
        return result;
    }

    public static void main(String[] args) {

    }
}

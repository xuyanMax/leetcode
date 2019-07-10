package greedy;

import java.util.*;

/**
 * @Author: xyx
 * @Date: 2019-06-30 02:18
 * @Version 1.0
 * <p>
 * Let us consider a different formulation,
 * where instead we have an infinite number of possible exclusive resources to use,
 * and we want to schedule all the activities using the smallest number resources
 * http://www.cs.umd.edu/class/fall2017/cmsc451-0101/Lects/lect07-greedy-sched.pdf
 * <p>
 * As before, we are given a collection R of n activity requests, each with a start and finish time[si, fi].
 * The objective is to find the smallest number d, such that it is possible to partition
 * R into d disjoint subsets R1, . . . , Rd, such that the events of Rj are mutually non conflicting,
 * for each j, 1≤j≤d.
 */
public class IntervalPartition {

    /**
     * 1. Sort all lectures based on start time in ascending order.
     * 2. Number of initial classrooms = 0
     * 3. While lecture to be scheduled:
     *    3.1 Take first lecture yet not scheduled,
     *    3.2 If there a already a class available for lecture's start time
     *        Assign lecture to the class.
     *    3.3 If not, then allocate a new classroom
     *        number of classroom = number of classroom + 1
     * 4. Return number of classrooms.
     *
     * @param intervals
     * @return
     */
    public int intervalPartition(Interval[] intervals) {
        //sort by earliest START time
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));
        //sort previously colored ones by END time
        PriorityQueue<Interval> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.getEnd()));

        for (int i = 0; i < intervals.length; i++) {
            Interval Ii = intervals[i];
            if (priorityQueue.isEmpty()) {
                priorityQueue.add(intervals[i]);
            } else {
                if (priorityQueue.peek().getEnd() > Ii.getStart()) { // 当前interval与之前所有已分配intervals冲突， 需要新涂上色
                    priorityQueue.add(Ii);
                } else {
                    priorityQueue.poll();// interval with the minimum finished time, and current interval shall be allocated to this group
                    priorityQueue.add(Ii);// update the new minimum finished time of that group by adding current interval to replace the removed one
                }
            }
        }
        return priorityQueue.size();//
    }


    }

    class Interval {
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public IntervalPartition() {
    }
}

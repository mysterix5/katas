package com.github.mysterix5.sumOfIntervals;

import java.util.*;

import static java.lang.Math.max;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if(intervals == null){
            return 0;
        }

        List<int[]> sortedIntervals = sortIntervals(intervals);

        List<int[]> meltedIntervals = meltIntervals(sortedIntervals);

        return sumUp(meltedIntervals);
    }

    private static int sumUp(List<int[]> meltedIntervals) {
        return meltedIntervals.stream()
                .map(x -> x[1]-x[0])
                .reduce(Integer::sum).orElse(0);
    }

    private static List<int[]> meltIntervals(List<int[]> sortedIntervals) {
        for (int i = 0; i < sortedIntervals.size()-1; i++) {
            int[] actual = sortedIntervals.get(i);
            int[] next = sortedIntervals.get(i+1);

            if(actual[1]>=next[0]){
                int[] newInterval = {actual[0],max(actual[1],next[1])};
                sortedIntervals.remove(i+1);
                sortedIntervals.set(i, newInterval);
                i--;
            }
        }
        return sortedIntervals;
    }


    private static List<int[]> sortIntervals(int[][] intervals) {
        List<int[]> sortedIntervals = new ArrayList<>();
        sortedIntervals.addAll(Arrays.asList(intervals));
        sortedIntervals.sort((i1,i2)->{
            int comp = i1[0] - i2[0];
            if(comp==0) {
                return i1[1]-i2[1];
            }else{
                return comp;
            }
        });

        return sortedIntervals;
    }
}


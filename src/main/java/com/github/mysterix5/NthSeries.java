package com.github.mysterix5;
public class NthSeries {

    public static String seriesSum(int n) {
        double returnVal = 0.0;
        for(int i = 0; i<n; i++){
            returnVal += 1.0/((double) i*3+1);
        }

        return String.format("%.2f", returnVal);
    }
}
package com.github.mysterix5;

import java.util.Arrays;

import static java.lang.Math.abs;

public class FindOutlier{
    static int find(int[] integers){
        int searchType = (((integers[0]&1)+(integers[1]&1)+(integers[2]&1))<2) ? 1 : 0;
        System.out.println(Arrays.toString(integers));

        return Arrays.stream(integers).filter(x -> (x&1)==searchType).findFirst().getAsInt();
    }
    static int find2(int[] integers){
        System.out.println(Arrays.toString(integers));
        if(Arrays.stream(integers)
                .filter(x -> (x%2)==0).count()==1){
            return Arrays.stream(integers)
                    .filter(x -> (x%2)==0).findFirst().getAsInt();
        }else{
            return Arrays.stream(integers).filter(x -> (abs(x)%2)==1).findFirst().getAsInt();
        }
    }
}


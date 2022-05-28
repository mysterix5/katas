package com.github.mysterix5.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

public class Solution2 {

    public static int bowling_score(String frames){
        List<String> splittedFrames = splitIntoFrames(frames);
        System.out.println("splitted frames: " + splittedFrames);
        return evaluate(splittedFrames);
    }

    public static int evaluate(List<String> frames){
        List<Integer> multiplier = new ArrayList<>(Collections.nCopies(21, 1));
        List<Integer> rolls = new ArrayList<>();
        int rollCounter = 0;
        for (int i = 0; i < frames.size(); i++) {
            String f = frames.get(i);
            for(char c: f.toCharArray()){
                if(Character.isDigit(c)){
                    rolls.add(Character.getNumericValue(c));
                } else if (c=='/') {
                    rolls.add(10-rolls.get(rolls.size()-1));
                    if(i<9) {
                        multiplier.set(rollCounter + 1, multiplier.get(rollCounter + 1) + 1);
                    }
                }else if(c=='X'){
                    rolls.add(10);
                    if(i<9) {
                        multiplier.set(rollCounter + 1, multiplier.get(rollCounter + 1) + 1);
                        multiplier.set(rollCounter + 2, multiplier.get(rollCounter + 2) + 1);
                    }
                }else{
                    throw new IllegalArgumentException("'" + c + "' is no valid symbol here. ");
                }
                rollCounter++;
            }
        }
        System.out.println("rolls: ");
        System.out.println(rolls);
        System.out.println("multiplier: ");
        System.out.println(multiplier);
        int result = 0;
        for(int i = 0; i<rolls.size(); i++){
            result += rolls.get(i)*multiplier.get(i);
        }
        System.out.println("result: " + result);
        return result;
    }

    public static List<String> splitIntoFrames(String f){
        List<String> frames = new ArrayList<>(Arrays.stream(f.split(" ")).toList());

        splitLast(frames);

        return frames;
    }

    public static void splitLast(List<String> frames){
        String last = frames.remove(frames.size()-1);
        while(last.length()>0) {
            if (last.charAt(0) == 'X') {
                frames.add("X");
                last = last.substring(1);
            }else{
                int index = min(2,last.length());
                frames.add(last.substring(0,index));
                last = last.substring(index);
            }
        }

    }
}

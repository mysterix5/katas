package com.github.mysterix5.bowling;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Solution {
    private static List<FrameEvaluation> frameList = new ArrayList<>();
    private static int score = 0;
    public static int bowling_score(String frames){
        frameList.clear();
        score=0;
        System.out.println("Input: " + frames);
        createList(frames);
        for (int i = 0; i < frameList.size(); i++) {
            FrameEvaluation f = frameList.get(i);
            System.out.println(i + ": " + f);
        }
        System.out.println("------------------------------");
        evaluate();
        return score;
    }

    private static void evaluate(){
        for(int i = 0; i<frameList.size()-2; i++){
            score += frameList.get(i).evaluate(frameList.get(i+1), frameList.get(i+2));
        }
        System.out.println("Total score: " + score);
    }

    private static void createList(String frames){
        frameList.add(new FrameEvaluation());
        String[] split = frames.split(" ");
        for (int i = 0; i < split.length-1; i++) {
            String frame = split[i];
            frameList.add(new FrameEvaluation(frame, false));
        }
        processLast(split[split.length-1], true);
        frameList.add(new FrameEvaluation());
    }
    private static void processLast(String lastFrame, boolean firstCall){
        if(lastFrame.charAt(0)=='X'){
            frameList.add(new FrameEvaluation("X", !firstCall));
            if(lastFrame.length()>1)
                processLast(lastFrame.substring(1), false);
        }else{
            frameList.add(new FrameEvaluation(lastFrame.substring(0,min(2,lastFrame.length())), !firstCall));
            if(lastFrame.length()>2)
                processLast(lastFrame.substring(2), false);
        }
    }
}


class FrameEvaluation {
    private boolean strike = false;
    private boolean spare = false;
    private int firstPoints = 0;
    private int secondPoints = 0;

    private boolean bonus = false;

    @Override
    public String toString() {
        return "FrameEvaluation{" +
                "strike=" + strike +
                ", spare=" + spare +
                ", firstPoints=" + firstPoints +
                ", secondPoints=" + secondPoints +
                ", bonus=" + bonus +
                '}';
    }

    public FrameEvaluation(){}
    public FrameEvaluation(String frame, boolean bonus){
        this.bonus = bonus;
        processFrame(frame);
    }

    public void processFrame(String frame){
        if(frame.length()==1){
            if(frame.equals("X")) {
                strike = true;
                firstPoints = 10;
            }else{
                firstPoints = Character.getNumericValue(frame.charAt(0));
            }
        } else if (frame.length()==2) {
            firstPoints = Character.getNumericValue(frame.charAt(0));
            if(Character.isDigit(frame.charAt(1))){
                secondPoints = Character.getNumericValue(frame.charAt(1));
            }else{
                secondPoints = 10-firstPoints;
                spare= true;
            }

        }
    }
    public int evaluate(FrameEvaluation firstFrame, FrameEvaluation secondFrame){
        System.out.println("-----Evaluator: ");
        System.out.println(this);
        System.out.println("Evaluates");
        System.out.println(firstFrame);

        int returnValue = 0;
        returnValue += firstFrame.firstPoints;
        returnValue += firstFrame.secondPoints;
        returnValue += spare && !firstFrame.bonus ? firstFrame.firstPoints : 0;
        returnValue += strike && !firstFrame.bonus ? firstFrame.firstPoints + firstFrame.secondPoints : 0;
        returnValue += strike && firstFrame.strike && !firstFrame.bonus ? secondFrame.firstPoints : 0;


        System.out.println("Result: " + returnValue);
        System.out.println("-----");
        return returnValue;
    }


}
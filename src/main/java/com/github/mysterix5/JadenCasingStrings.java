package com.github.mysterix5;

public class JadenCasingStrings {

    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        System.out.println(phrase);
        if(phrase == null || phrase == "")
            return null;

        var wordList = phrase.split(" ");
        StringBuilder strb = new StringBuilder();
        for(var w: wordList){
            strb.append(w.substring(0, 1).toUpperCase() + w.substring(1) + " ");
        }
        System.out.println(strb.toString());
        return strb.toString().substring(0,strb.length()-1);
    }
}
package com.github.mysterix5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {

    public static HashSet<String> singlePermutations(String s) {
        List<String> returnList = new ArrayList<>();

        List<Character> charList = s.chars()
                .mapToObj(c -> (char) c)
                .toList();

        List<PermutationEntry> workonList = new ArrayList<>();
        workonList.add(new PermutationEntry("", charList));

        while(!workonList.isEmpty()){
            PermutationEntry e = workonList.remove(0);
            if(e.theList.size()==1){
                returnList.add(e.s + e.theList.get(0));
            }else{
                for(Character c: e.theList){
                    var listCopy = new ArrayList<>(e.theList);
                    listCopy.remove(c);
                    workonList.add(new PermutationEntry(e.s + c, listCopy));
                }
            }
        }

        System.out.println(returnList);
        var returnSet = new HashSet<>(returnList);
        System.out.println(returnSet);
        return returnSet;
    }
}

class PermutationEntry{
    public String s;
    public List<Character> theList;

    public PermutationEntry(String s, List<Character> theList){
        this.s = s;
        this.theList = theList;
    }
}
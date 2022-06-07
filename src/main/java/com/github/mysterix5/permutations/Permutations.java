package com.github.mysterix5.permutations;

import java.util.*;
import java.util.stream.Collectors;

class Permutations {

    public static List<String> singlePermutations(String s) {
        System.out.println("input: " + s);
        Set<String> returnSet = new HashSet<>();
        List<Character> charList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        permutationRecursive(returnSet, charList, "");
        System.out.println("return: " + returnSet);

        return returnSet.stream().toList();
    }

    private static void permutationRecursive(Set<String> returnSet, List<Character> charList, String s){
        if(charList.isEmpty()){
            returnSet.add(s);
            return;
        }
        for(int i = 0; i< charList.size(); i++){
            List<Character> listCopy = new ArrayList<>(charList);
            permutationRecursive(returnSet, listCopy, s + listCopy.remove(i));
        }
    }

}
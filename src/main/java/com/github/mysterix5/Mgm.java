package com.github.mysterix5;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Mgm {

    public static Optional<Character> doubleSymbol(String s) {

        Set<Character> prev = new HashSet<>();
        for(int i = 0; i<s.length(); i++){
            char actual = s.charAt(i);
            if(!prev.add(actual)){
                return Optional.of(actual);
            }
        }

        return Optional.empty();
    }
}

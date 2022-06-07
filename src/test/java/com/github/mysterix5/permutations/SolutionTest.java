package com.github.mysterix5.permutations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.*;


public class SolutionTest {

    @Test public void example1() {
        assertEquals( new ArrayList<>(List.of("a")),
                Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example2() {
        assertEquals( new ArrayList<>(Arrays.asList("ab","ba")),
                Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example3() {
        assertEquals( new ArrayList<>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }
}
package com.github.mysterix5;

        import org.junit.jupiter.api.Test;

        import java.util.*;
        import java.util.stream.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;


public class permutations2Test {

    @Test
    public void example1() {
        assertEquals( new ArrayList<String>(Arrays.asList("a")),
                Permutations2.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example2() {
        assertEquals( new ArrayList<String>(Arrays.asList("ab","ba")),
                Permutations2.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example3() {
        assertEquals( new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations2.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }
}
package com.github.mysterix5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {

    @Test public void sampleTests() {

        String a = ".W.\n"+
                ".W.\n"+
                "...",

                b = ".W.\n"+
                        ".W.\n"+
                        "W..",

                c = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......",

                d = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        ".....W\n"+
                        "....W.";

        assertEquals(true,  PathFinder.pathFinder(a));
        assertEquals(false, PathFinder.pathFinder(b));
        assertEquals(true,  PathFinder.pathFinder(c));
        assertEquals(false, PathFinder.pathFinder(d));
    }

    @Test
    public void hardTest(){
        String maze = """
                .....W..W.W.....W..
                .W..W.W.W.....WW...
                WW..WW.WW....W.....
                ........W.WW...W..W
                .........W.W..W....
                ...................
                W.....W..W.W....WW.
                WW..WW.W.W.WW.W.W..
                .W.W.W........W.W..
                ......W........WW.W
                ...W....W..W.WWWWWW
                .....W.WW........WW
                ..W....W........W..
                .W.....W.WW..W.....
                .....WW.W......W...
                W..W.......W......W
                ........W.....W....
                W.W..WW.....W....W.
                .W...W.W.WW.W...WW.""";

        assertEquals(true, PathFinder.pathFinder(maze));
    }
}
package com.github.mysterix5;

import java.util.*;

public class PathFinder {
    static boolean pathFinder(String maze) {
        var splitMazeString = maze.split("\n");
//        System.out.println(Arrays.toString(splitMazeString));
        for(var l: splitMazeString){
            System.out.println(l);
        }

        int n = splitMazeString.length;
        System.out.println("n: " + n + ", fields: " + n*n);
        if(n == 1){
            return true;
        }
        Coord goal = new Coord(n-1,n-1, 0.0f);
        Coord start = new Coord(0,0, goal);

        boolean[][] visited = new boolean[n][n];

        TreeSet<Coord> workingList = new TreeSet<>();
        workingList.add(start);

        boolean winner = false;
        int counter = 0;
        while(!workingList.isEmpty()){
            counter++;
            Coord actual = workingList.first();
            workingList.remove(actual);
            visited[actual.x][actual.y] = true;

//            System.out.println("working on: " + actual);

            List<Coord> newFields = new ArrayList<>();
            newFields.add(new Coord(actual.x-1, actual.y, goal));
            newFields.add(new Coord(actual.x+1, actual.y, goal));
            newFields.add(new Coord(actual.x, actual.y-1, goal));
            newFields.add(new Coord(actual.x, actual.y+1, goal));

            for(Coord f: newFields){
                if(f.x == goal.x && f.y == goal.y){
                    winner = true;
                }
                if(f.x<0 || f.x>=n || f.y<0 || f.y>=n){
                    continue;
                }
                if(visited[f.x][f.y]){
                    continue;
                }
                if(splitMazeString[f.x].charAt(f.y) == '.'){
                    workingList.add(f);
                }
            }

        }
        System.out.println("looked at " + counter + " fields");
        // without sorting: 1780286
        System.out.println(Arrays.deepToString(visited).replace("], ", "]\n"));
        return winner;
    }


}

class Coord implements Comparable<Coord>{
    public int x;
    public int y;
    public float dist;
    public int pathDist;

    public Coord(int x, int y, Coord goal) {
        this.x = x;
        this.y = y;
        this.dist = (x-goal.x)*(x-goal.x) + (y-goal.y)*(y-goal.y);
        if(x<y){
            this.dist+=0.1f;
        }
    }
    public Coord(int x, int y, float dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y && Float.compare(coord.dist, dist) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dist);
    }

    @Override
    public int compareTo(Coord o) {
//        return Float.compare(this.dist, o.dist);
        if(this.dist>o.dist){
            return -1;
        } else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                '}';
    }
}
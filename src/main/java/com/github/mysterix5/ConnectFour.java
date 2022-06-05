package com.github.mysterix5;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectFour {
    static int[][] field;
    public static String whoIsWinner(List<String> piecesPositionList) {
        field = new int[6][7];
        System.out.println(piecesPositionList);
        int winner = 0;
        for(String move: piecesPositionList){
            winner = addOnePieceToField(move);
            if(winner!=0){
                break;
            }
        }
        System.out.println("Winner? " + intToWinner(winner));
        System.out.println(fieldToString(field));
        System.out.println("--------------------------");
        return intToWinner(winner);
    }
    private static String intToWinner(int winner){
        if(winner == 0){
            return "Draw";
        }
        if(winner == 1){
            return "Red";
        }
        return "Yellow";
    }
    private enum ColIndex {
        A,B,C,D,E,F,G;
        public static int getNum(String in) {
            return valueOf(in).ordinal();
        }
        public static int getNum(char in) {
            return valueOf(String.valueOf(in)).ordinal();
        }
    }
    private static int addOnePieceToField(String move){
        var x = move.split("_");
        int colIndex = ColIndex.getNum(x[0]);
        int rowIndex = -1;
        int player = x[1].equals("Red") ? 1 : 2;
        for (int i = 0; i < field.length; i++) {
            int[] row = field[i];
            if (row[colIndex] == 0) {
                row[colIndex] = player;
                rowIndex = i;
                break;
            }
        }
        if(checkForWinOnNewMove(rowIndex, colIndex)){
            return player;
        }
        return 0;
    }

    private static class ConnectFourIterator{
        int startRow;
        int startCol;
        int actualRow;
        int actualCol;
        int walkDirRow;
        int walkDirCol;

        public void resetStart(int startRow, int startCol){
            this.startRow = startRow;
            this.startCol = startCol;
        }
        public void reset(int walkDirRow, int walkDirCol) {
            this.actualRow = this.startRow;
            this.actualCol = this.startCol;
            this.walkDirRow = walkDirRow;
            this.walkDirCol = walkDirCol;
        }

        private boolean next(){
            actualRow += walkDirRow;
            actualCol += walkDirCol;
            if(actualRow<0 || actualCol<0 || actualRow >=field.length || actualCol>=field[0].length){
                return false;
            }
            return true;
        }

        public boolean run(){
            int score = 1;
            int player = field[startRow][startCol];
            while(next()){
                if(field[actualRow][actualCol]!=player){
                    break;
                }
                score++;
            }
            reset(-walkDirRow, -walkDirCol);
            while(next()){
                if(field[actualRow][actualCol]!=player){
                    break;
                }
                score++;
            }
            return score>=4;
        }

    }

    private static boolean checkForWinOnNewMove(int rowIndex, int colIndex) {
        var it = new ConnectFourIterator();
        it.resetStart(rowIndex, colIndex);
        it.reset(0,1);
        if(it.run())return true;
        it.reset(1,0);
        if(it.run())return true;
        it.reset(1,1);
        if(it.run())return true;
        it.reset(1,-1);
        if(it.run())return true;

        return false;
    }

    private static String fieldToString(int[][] sudoku){

        return "{" + Arrays.stream(sudoku).map(
                x -> "{" + Arrays.stream(x).boxed().map(Object::toString)
                        .collect( Collectors.joining( "," ) ) + "}\n"
        ).collect(Collectors.joining(",")) + "}";
    }

}
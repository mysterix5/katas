package com.github.mysterix5;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        //do your magic
        System.out.println("new sudoku:");
        System.out.println(printSudoku(sudoku));

        for(int i = 0; i<9; i++){
            if(!checkSet(getRow(sudoku,i))){
                return false;
            }
            if(!checkSet(getCol(sudoku,i))){
                return false;
            }
        }
        for(int row = 0; row<3; row++){
            for(int col = 0; col<3; col++){
                if(!checkSet(getSubSquare(sudoku, row, col))){
                    return false;
                }
            }
        }
        return true;
    }

    private static Set<Integer> getSubSquare(int[][] sudoku, int row, int col){
        var asdf =  Arrays.asList(sudoku)
                .subList(row*3, row*3+3);
//        System.out.println(asdf.stream().map(x -> Arrays.toString(x)).collect(Collectors.toList()));
        var asdf2 = asdf.stream()
                .map(x -> Arrays.stream(x).boxed().collect(Collectors.toList())).toList();
        var asdf3 = asdf2.stream()
                .map(x -> x.subList(col * 3, col * 3 + 3)).toList();
//        System.out.println(printSudoku(asdf3));
        var asdf4 = asdf3.stream().flatMap(List::stream).collect(Collectors.toSet());
//        System.out.println(asdf4);

        return Arrays.asList(sudoku)
                .subList(row*3, row*3+3).stream()
                .map(x-> Arrays.stream(x).boxed().collect(Collectors.toList()).subList(col*3, col*3+3))
                .flatMap(List::stream).collect(Collectors.toSet());
    }
    private static String printSudoku(int[][] sudoku){

        return "{" + Arrays.stream(sudoku).map(
                x -> "{" + Arrays.stream(x).boxed().map(Object::toString)
                        .collect( Collectors.joining( "," ) ) + "}"
        ).collect(Collectors.joining(",")) + "}";

    }
    private static String printSudoku(List<List<Integer>> sudoku){

        return "{" + sudoku.stream().map(
                x -> "{" + x.stream().map(Object::toString)
                        .collect( Collectors.joining( "," ) ) + "}"
        ).collect(Collectors.joining(",")) + "}";

    }
    private static Set<Integer> getRow(int[][] sudoku, int index){
        return Arrays.stream(sudoku).map(x -> x[index]).collect(Collectors.toSet());
    }
    private static Set<Integer> getCol(int [][] sudoku, int index){
        return  Arrays.stream(sudoku[index]).boxed().collect(Collectors.toSet());
    }
    private static boolean checkSet(Set<Integer> sudokuSet){
        if(sudokuSet.contains(0)){
            return false;
        }
        return sudokuSet.size() == 9;
    }
}
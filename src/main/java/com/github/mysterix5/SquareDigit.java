package com.github.mysterix5;

public class SquareDigit {

    public int squareDigits(int n) {
        System.out.println("input: " + n);
        String numberString = Integer.toString(n);
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++){
            int digit = Character.getNumericValue(numberString.charAt(i));
            int square = digit*digit;
            returnString.append(square);
        }
        System.out.println("return: " + returnString);
        return Integer.parseInt(returnString.toString());
    }


}

package com.github.mysterix5.strip_comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        List<String> lines = splitIntoLines(text);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for(String commentSymbol: commentSymbols){
                if(lines.get(i).isEmpty()){
                    break;
                }
                var splitComment = lines.get(i).split(Pattern.quote(commentSymbol));
                if(splitComment.length > 0){
                    if(splitComment[0].length()<line.length()){
                        lines.set(i, splitComment[0]);
                    }
                } else {
                    lines.set(i, "");
                }

            }
            lines.set(i, lines.get(i).stripTrailing());
        }

        return String.join("\n", lines);
    }

    private static List<String> splitIntoLines(String text) {

        return new ArrayList<>(Arrays.stream(text.split("\n")).toList());
    }
}

package com.wongnai.interview.movie.util;

public class util {

    public static String getDataLowerCaseNotSpace(String str){
        return "|" + str.replace(" ","|").toLowerCase() + "|";
    }

    public static boolean checkOneWord(String queryText){
        return queryText.trim().indexOf(" ") == -1;
    }

    public static void main(String[] args) {
        String[] queryTextSplit = "palm".split(" ");
        System.out.print(queryTextSplit.length);
    }
}

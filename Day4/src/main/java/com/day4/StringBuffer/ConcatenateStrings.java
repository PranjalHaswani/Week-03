package com.day4.StringBuffer;

public class ConcatenateStrings {
    public static void main(String[] args) {
        //Example array of strings
        String[] strings= {"Hello", " ", "Children", " How", " Are", " You", " ?"};
        //Concatenate using StringBuffer
        String result= stringConcatenate(strings);
        //Print the result
        System.out.println(result);
    }
    public static String stringConcatenate(String[] strings){
        //Create a StringBuffer object
        StringBuffer stringBuffer= new StringBuffer();
        //iterate through each string in the array and append it to the StringBuffer
        for(String str: strings){
            stringBuffer.append(str);
        }
        //Return the concatenated string
        return stringBuffer.toString();
    }
}

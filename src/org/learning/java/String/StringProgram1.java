package org.learning.java.String;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by  preeti on 5/1/22 at 5:00 PM.
 */
public class StringProgram1 {


    /*
    //Creating string object with and without new keyword

    static String stringWitoutNewKeyword = "Hello 1 World";

    static String  stringWithNewKeyword = new String("Hello World");

    static String  stringWithNewKeyword2 = new String("Hello World");
    public static void main(String[] args) {
        //

        System.out.println("Empty String "+new String());
        stringWitoutNewKeyword.chars();
        stringWitoutNewKeyword.charAt(2);

        stringWitoutNewKeyword.compareTo("ComparedString");
        stringWitoutNewKeyword.compareToIgnoreCase("COMparedString");
        stringWitoutNewKeyword.lastIndexOf("ld"); //O/p: 9
        char[] destChar = {2,3,4,5,6,7};
        stringWitoutNewKeyword.getChars(1,4,destChar,0);//Copies characters from this string into the destination character array.
        //The first character to be copied is at index srcBegin; the last character to be copied is at index srcEnd-1
        System.out.println("stringWitoutNewKeyword.codePointAt(0); "+stringWitoutNewKeyword.codePointAt(10)); //Returns the character (Unicode code point) at the specified index.
                                        // The index refers to char values (Unicode code units) and ranges from 0 to length()- 1.
                                        // If the char value specified at the given index is in the high-surrogate range, the
                                        // following index is less than the length of this String, and the char value at the
                                        // following index is in the low-surrogate range, then the supplementary code point corresponding
                                        // to this surrogate pair is returned. Otherwise, the char value at the given index is returned.



        stringWitoutNewKeyword.indexOf(111);//Returns the index within this string of the first occurrence of the specified substring.
        stringWitoutNewKeyword.indexOf("el");
        stringWitoutNewKeyword.indexOf("el",2);
        stringWitoutNewKeyword.codePoints();
        stringWitoutNewKeyword.getBytes();
        stringWitoutNewKeyword.codePointBefore('o');
        stringWitoutNewKeyword.codePointCount(1,5);//returns the number of Unicode code points in the specified range.


        System.out.println(" stringWitoutNewKeyword.copyValueOf(destChar) "+  stringWitoutNewKeyword.copyValueOf(destChar)); //a String that contains the characters of the character array.
        // This method is Equivalent to valueOf(char[]).

        //encoding of string into the sequence of bytes and keeps it in an array of bytes.
        stringWitoutNewKeyword.getBytes();
        stringWitoutNewKeyword.formatted();

    }*/
}

class StringDemo {
    public static void main(String[] args) {
        char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(helloArray);
        System.out.println(new String(helloArray));

        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
        }

        palindrome.getChars(0, len, tempCharArray, 0);

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversePalindrome = new String(charArray);
        System.out.println(reversePalindrome);

        String concateWxample = "Hello "+"Concate";
        System.out.println(concateWxample);

        System.out.printf("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s",
                10.24, 4, "String\n");

        String fs;
        fs = String.format("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s",
                10.24, 4, "String");
        System.out.println(fs);

        String data = "This is a text inside the file.";

        try {
            PrintStream output = new PrintStream("output.txt");

            output.print(data);
            output.println("\nI am 25 years old.");
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}


class ValueOfDemo {
    public static void main(String[] args) {

        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
        // convert strings to numbers
        float a = (Float.valueOf(args[0])).floatValue();
        float b = (Float.valueOf(args[1])).floatValue();

        // do some arithmetic
        System.out.println("a + b = " +
        (a + b));
        System.out.println("a - b = " +
        (a - b));
        System.out.println("a * b = " +
        (a * b));
        System.out.println("a / b = " +
        (a / b));
        System.out.println("a % b = " +
        (a % b));
        } else {
        System.out.println("This program " +
        "requires two command-line arguments.");
        }

        double d = 858.48;
        String s = Double.toString(d);

        int dot = s.indexOf('.');

        System.out.println(dot + " digits " +
                "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
                " digits after decimal point.");
    }
}

class Filename {
    private String fullPath;
    private char pathSeparator,
            extensionSeparator;

    public Filename(String str, char sep, char ext) {
        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;
    }

    public String extension() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        return fullPath.substring(dot + 1);
    }

    // gets filename without extension
    public String filename() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(sep + 1, dot);
    }

    public String path() {
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(0, sep);
    }
    public static void main(String[] args) {
        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.');
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());
    }
}

class RegionMatchesDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // adds 9 character string at beginning
        sb.append("Greetings");
        sb.setLength(39);
        System.out.println(sb.capacity());

        StringBuilder sb1 = new StringBuilder("abcd    12");
        System.out.println("sb1.capacity() "+sb1.capacity());
        System.out.println(sb1.charAt(0));
        String hannah = "Did Hannah see bees? Hannah did.";
        System.out.println("hannah.length()"+hannah.length());
        System.out.println("hannah.charAt(12)"+hannah.charAt(11));


        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0;
             i <= (searchMeLength - findMeLength);
             i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt)
            System.out.println("No match found.");
    }

}

class ComputeInitials {
    public static void main(String[] args) {
        String myName = "Fred F. Flintstone";
        StringBuffer myInitials = new StringBuffer();
        int length = myName.length();

        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(myName.charAt(i))) {
                myInitials.append(myName.charAt(i));
            }
        }
        System.out.println("My initials are: " + myInitials);
    }
}

class Anagram {

    public static boolean areAnagrams(String string1,
                                      String string2) {

        String workingCopy1 = removeJunk(string1);
        String workingCopy2 = removeJunk(string2);

        workingCopy1 = workingCopy1.toLowerCase();
        workingCopy2 = workingCopy2.toLowerCase();

        workingCopy1 = sort(workingCopy1);
        System.out.println("workingCopy1 after sorting "+workingCopy1);
        workingCopy2 = sort(workingCopy2);
        System.out.println("workingCopy2 after sorting "+workingCopy2);

        return workingCopy1.equals(workingCopy2);
    }

    protected static String removeJunk(String string) {
        int i, len = string.length();
        StringBuilder dest = new StringBuilder(len);
        char c;

        for (i = (len - 1); i >= 0; i--) {
            c = string.charAt(i);
            if (Character.isLetter(c)) {
                dest.append(c);
            }
        }
        System.out.println("String after removing junk: "+dest);
        return dest.toString();
    }

    protected static String sort(String string) {
        char[] charArray = string.toCharArray();

        java.util.Arrays.sort(charArray);

        return new String(charArray);
    }

    public static void main(String[] args) {
        String string1 = "Cosmo and Laine:";
        String string2 = "Maid, clean soon!";

        System.out.println();
        System.out.println("Testing whether the following "
                + "strings are anagrams:");
        System.out.println("    String 1: " + string1);
        System.out.println("    String 2: " + string2);
        System.out.println();

        if (areAnagrams(string1, string2)) {
            System.out.println("They ARE anagrams!");
        } else {
            System.out.println("They are NOT anagrams!");
        }
        System.out.println();

        System.out.println("Examining Box classes");
        int i = 2;
        Box box = new Box();
        box.set(i); //autoboxing since expecting Object and passing primitive value
        System.out.println("box.get: "+box.get());
    }
}

class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}

class Example<T> {
    // Not a generic method!
    public  void method(T param) { }
}

interface A {
    void methodInterface();
}
interface B{
    void methodInterface();
}
class c implements A,B{
    public static void main(String[] args) {

    }
    @Override
    public void methodInterface() {
        System.out.println("methodInterface1");
    }
}


class ContinueWithLabelDemo {

    public static void main(String[] args) {

        String searchMe = "Look for s a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }
}

class ReverseString{
    public static void reverseStringUsingCharArray(String stringToBeReversed){
        /* Approach with char array
        * 1. Since the strings are immutable objects, you need to create another string to reverse them.
        *    The string class doesn't have a reverse method to reverse the string. It has a toCharArray() method to
        *    do the reverse.
        * a. convert string into char array
        * b. Reverse char array with for loop
        * */

        int strLength = stringToBeReversed.length();
        char[] stringInChars = new char[strLength];
        char[] reverseString = new char[strLength];

        /*//1. method 1 to get an char array from String
        stringToBeReversed.getChars(0,strLength,stringInChars,0); //char String*/

        //2. method 2 to get an char array
        stringInChars = stringToBeReversed.toCharArray();



      /* //1.  //string Reverse tried with reverse loop i.e from higher index to lower index   ---> NOT RECOMMENDED
        for(int i=strLength; i >0; i--) {  //tr
            reverseString[strLength - i] = stringInChars[i-1];
        }*/

        //2. String Reversal with forward loop
        for (int i=0; i<strLength; i++){
            reverseString[i] = stringInChars[strLength - i - 1];
        }

        for (char c: reverseString) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        String str = "Hello";

        //1. Approach One
        reverseStringUsingCharArray(str);

        //2. Approach two
        //reverse String using StringBuilder or String Buffer

        StringBuilder stringBuilderVar = new StringBuilder();
        stringBuilderVar.append(str);     // append a string into StringBuilder stringBuildervarible
        stringBuilderVar.reverse();        //  // reverse is inbuilt method in StringBuilder to use reverse the string
        System.out.println("Reversed String: "+ stringBuilderVar);

       /* *//*Alternatively, you can also use the StringBuffer class reverse() method similar to the StringBuilder.
        Both the StringBuilder class and StringBuffer class, work in the same way to reverse a string in Java.
        Considering reverse, both have the same kind of approach. Although, StringBuilder class is majorly
        appreciated and preferred when compared to StringBuffer class. The StringBuilder class is faster and
        not synchronized. These StringBuilder and StringBuffer classes create a mutable sequence of characters.

        The StringBuilder and StringBuffer classes are two utility classes in java that handle resource sharing of string manipulations. *//*

        Some main methods of String Buffer:

        stringBuilderVar.toString();
        stringBuilderVar.append('c');
        stringBuilderVar.reverse();
        stringBuilderVar.delete(0,4);
        stringBuilderVar.deleteCharAt(2);
        stringBuilderVar.compareTo(stringBuilderVar);
        stringBuilderVar.indexOf("c");
        stringBuilderVar.insert(2,'c');
        stringBuilderVar.lastIndexOf("c"); //Returns the index within this string of the last occurrence of the specified substring. The last occurrence of the empty string "" is considered to occur at the index value this.length()
        stringBuilderVar.replace(0,2,"a");
        stringBuilderVar.getChars(0,1,stringBuilderDestination,2);
        stringBuilderVar.isEmpty();
        stringBuilderVar.substring(1,2);
        stringBuilderVar.subSequence(1,2); //returns substring thus recommended to use substring.
        stringBuilderVar.trimToSize(); //Attempts to reduce storage used for the character sequence. If the buffer is larger than necessary to hold its current sequence of characters, then it may be resized to become more space efficient.
        stringBuilderVar.setCharAt(2,'v');
        stringBuilderVar.indexOf("ac");//Returns: the index of the first occurrence of the specified substring, starting at the specified index, or -1 if there is no such occurrence.
        stringBuilderVar.appendCodePoint(67);//Params:codePoint – a Unicode code point
        */


        //By Converting a String to Bytes

        String inputvalue = "Independent";

        // getBytes() is inbuilt method  to convert string
        // into bytes[].
        byte[] strAsByteArray = inputvalue.getBytes();

        byte[] resultoutput = new byte[strAsByteArray.length];

        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            resultoutput[i] = strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println(new String(resultoutput));

        /*// Exercise of byte array String class has byte[] array constructor

        for(Byte b : resultoutput)
             System.out.print(b+" ");

        byte[] byteValue = {116};
        System.out.println(new String(byteValue));*/





        //Reverse string using ArrayList
        String input = "Reverse a String";
        char[] charStr = input.toCharArray();

        List<Character> revString = new ArrayList<>();

        for (char c : charStr)
            revString.add(c);

        Collections.reverse(revString);

        ListIterator li = revString.listIterator();

        while (li.hasNext())
            System.out.print(li.next());

        List<String> stack =  new Stack<>();

        String sentances = "i like this program very much";
        System.out.println("\nSentences length "+ sentances.length());
        reverseOrderOfWordsInSentance(sentances);
        reverseOrderUsingStringBuilder(sentances);
    }

    private static void reverseOrderUsingStringBuilder(String sentances) {
        String[] stringArray = sentances.split("\\s");
        StringBuilder stringBuilderAr
    }

    private static void reverseOrderOfWordsInSentance(String sentances) {

        System.out.println("\nreverseOrderOfWordsInSentance here");
        String[] stringArray =  sentances.split("\\s");
        System.out.println(Arrays.toString(stringArray)); //Printing String Array with brackets
        int length = stringArray.length;
        ArrayList<String> StringArray =  new ArrayList<>();
        String[] reverseOrder = new String[length];
        for (int i=0; i<length; i++)
          reverseOrder[i]  = stringArray[length - i -1];
        for (String word: reverseOrder ) {
            System.out.print(word+ " ");
        }
    }
}


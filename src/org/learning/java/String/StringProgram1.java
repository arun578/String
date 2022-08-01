package org.learning.java.String;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.jar.JarOutputStream;
import java.util.stream.IntStream;

/**
 * Created by  preeti on 5/1/22 at 5:00 PM.
 */
public class StringProgram1 {

    public static void main(String[] args) {

        /*The String class represents character strings. All string literals in Java programs, such as "abc", are implemented as instances of this class.
            Strings are constant; their values cannot be changed after they are created. String buffers support mutable strings. Because String objects are immutable
            they can be shared. For example:*/
            String str = "abc";
            //is equivalent to:
            char data[] = {'a', 'b', 'c'};
            String str1 = new String(data); //Since internally  char value[];  this.value = Arrays.copyOf(value, value.length);

            //Here are some more examples of how strings can be used:
            System.out.println("abc");
            String cde = "cde";
            System.out.println("abc" + cde);
            //substring example:
            String c = "abc".substring(2,3);
            String d = cde.substring(1, 2);

        /*The class String includes methods for examining individual characters of the sequence, for comparing strings, for searching strings, for extracting substrings,
        and for creating a copy of a string with all characters translated to uppercase or to lowercase. Case mapping is based on the Unicode Standard version specified
        by the Character class.
        The Java language provides special support for the string concatenation operator (+), and for conversion of other objects to strings. For additional
        information on string concatenation and conversion, see The Java™ Language Specification.
        Unless otherwise noted, passing a null argument to a constructor or method in this class will cause a NullPointerException to be thrown.
        A String represents a string in the UTF-16 format in which supplementary characters are represented by surrogate pairs (see the section Unicode Character
        Representations in the Character class for more information or one note character and Numbers section). Index values refer to char code units, so a supplementary character uses two positions in a String.
        The String class provides methods for dealing with Unicode code points (i.e., characters), in addition to those for dealing with Unicode code units (i.e., char values).
        Unless otherwise noted, methods for comparing Strings do not take locale into account. The java.text.Collator class provides methods for finer-grain, locale-sensitive String comparison.*/

        //1.1
            System.out.println("\n1.1--> In Java, string is basically an object that represents sequence of char values.");
            char[] ch={'S','t','r','i','n','g',' ','i','s',' ','c','h','a','r','S','e','q','u','e','n','c','e',' ','o','b','j','e','c','t','.'};
            String s = new String(ch);
            System.out.println("Output: "+s); //converting char array to string

        //1.2
        System.out.println("1.2--> Allocates a new String that contains characters from a subarray of the Unicode code point array argument.");
            int[] intArray = {66,67,68,69,70};
         //Allocates a new String that contains characters from a subarray of the Unicode code point array argument.
            String intArraytoString = new String(intArray, 0, intArray.length);
            System.out.println("intArraytoString: "+intArraytoString); //  O/p: intArraytoString: BCDEF

        //Ways to Create Strings
        //2.1. String literal --> Creating string object without new keyword
            /*This is the simplest and direct way to declare a string. It is done using double-quotes. Each time you create a string literal, the JVM checks the "string constant pool" first.
            If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool.
            Java uses String constant pool to make Java "more memory efficient" (because no new objects are created if it exists already in the string constant pool)*/
            String stringWitoutNewKeyword = "Hello 1 World";
            String stringWitoutNewKeyword2 = "Hello 1 World"; //It doesn't create a new instance

        //2.2 Using new keyword
            /*The ‘new’ keyword forces a new instance to be always created even if the same value was used previously or not. These strings are stored in heap and not string constant pool.*/
            String  stringWithNewKeyword = new String("Hello new World"); //forces object to create in heap memory and not string constant pool.

        //2.3 Using String.intern() method --> Creating strings by using the 'new' keyword places the string in the heap but outside the string constant pool. If we want the
        // strings having the same value to be placed inside the string pool if not already then we can use String.intern method.
            System.out.println("2.3-->Creating String in Heap and in SCP(String constant pool) as well if not created already.");
            String s231=new String("hello");
            String s232="hello";
            String s233=s231.intern();//returns string from pool, now it will be same as s2
            System.out.println(s231==s232);//false because reference variables are pointing to different instance
            System.out.println(s232==s233);//true because reference variables are pointing to same instance


        // Summary to create new String:
            String s1="java";//creating string by Java string literal
            char ch1[]={'s','t','r','i','n','g','s'};
            String s2 = new String(ch1);//converting char array to string
            String s3 = new String("example");//creating Java string by new keyword
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);

            /*String Conclusions:
                1. Strings in Java are Objects that are backed internally by a char array. Since arrays are immutable(cannot grow), Strings are immutable as well.
                    Whenever a change to a String is made, an entirely new String is created. i.e existing String object won't change.
                2. One main advantage of Java String Pool allows caching of string and reusability.

                3. String Pool in Java is a special storage space in Java heap memory. It is also known as String Constant Pool or String Intern Pool.
                4. We can create string of single character i.e String charString = "c"; but recommended way is to create char variable if you need single character only. Because
                char is primitive data type and primitive data types gets space in Stack and we know Stack is facter than heap Memory
             */

        //String Methods:

        //3.1 String Length
            System.out.println("\n 3.1-> String Length method");
            System.out.println("String Length: "+s3.length()); //The length of the sequence of characters represented by this object. Since String is internally an array thus s3.length() returns same value as array.length.
            System.out.println("Empty String "+new String());

        // 3.2 String isEmpty method: checks if the input string is empty or not. Note that here empty means the number of characters contained in a string is zero.
            System.out.println("\n 3.2-> String isEmpty method");
            String stringEmptyTestVar1 ="";
            String stringEmptyTestVar2 ="javatpoint";
            System.out.println("stringEmptyTestVar1.isEmpty() "+stringEmptyTestVar1.isEmpty());
            System.out.println("stringEmptyTestVar1.isEmpty() "+stringEmptyTestVar2.isEmpty());

        //3.3. null String:  A null string is a string that has no value.
            System.out.println("\n3.3-> null String");
            String strTest1 = ""; // empty string
            String strTest2 = null; // null string. It is also not containing any characters.
            //strTest2.isEmpty() // o/p: Exception in thread "main" java.lang.NullPointerException
            //to check whether string is null or not we need to use == operator
            System.out.println(strTest2 == null); //true

        //3.4 Blank Strings: Blank strings are those strings that contain only white spaces.
            String strWithWhiteSpace = "     ";
            if(strWithWhiteSpace.length() > 0 && str.trim().isEmpty())
            {
                System.out.println("The string is blank. \n");
            }

        // Concatenating Strings
            System.out.print("\n4-> Concatenating Strings:-");
        //4.1
            System.out.println("\n4.1-> The String class includes a method for concatenating two strings:−");
            String string1 = "String1";
            String string2 = "String2";
            String stringConcat = string1.concat(string2);
            System.out.println("String Concat example: "+stringConcat);

       //4.2
            System.out.println("4.2-> Concatenated String with the + operator");
            String stringConcatWithPlusOperator = string1+string2;
            System.out.println(stringConcatWithPlusOperator);

      //4.3 Java Numbers and Strings
        //Adding Numbers and Strings : Java uses the + operator for both addition and concatenation i.e. Numbers are added, Strings are concatenated.
            //4.3.1: If you add two numbers, the result will be a number:
                int x = 10;
                int y = 20;
                int z = x + y;  // z will be 30 (an integer/number)
                System.out.println("\n+ operator for Numbers works as addition: "+z);

            //4.3.2: If you add two strings, the result will be a string concatenation:
                String x1 = "10";
                String y1 = "20";
                String z1 = x1 + y1;  // z will be 1020 (a String)
                System.out.println("+ operator for strings works as Concatenation: "+z1);

            // 4.3.3: If you add a number and a string, the result will be a string concatenation:
                String xStr = "10";
                int yInt = 20;
                String zStr = xStr + yInt;  // z will be 1020 (a String)
                System.out.println("+ operator for number and a string works as Concatenation: "+zStr);

       //5
            System.out.println("\n5-> Creating Format Strings");
        /*We have printf() and format() methods to print output with formatted numbers. The String class has an equivalent class method, format(), that returns a String object rather than a PrintStream object.
          Using String's static format() method allows you to create a formatted string that you can reuse, as opposed to a one-time print statement.
          For example, instead of− */
            int integer = 2;
            float floatNumber = 5.4f;
            String stringVar = "StringValue";
            System.out.printf("The value of the float variable is: " +
                    "%f, while the value of the integer " +
                    "variable is: %d, and the string " +
                    "is: %s\n", floatNumber, integer, stringVar);

        //We can also write reusable formatted String
            String fs = String.format("The value of the float variable is: " +
                    "%f, while the value of the integer " +
                    "variable is: %d, and the string " +
                    "is: %s\n", floatNumber, integer, stringVar);
            System.out.println(fs);

        //6. String charAt() Method: returns a char at the specified index in the string.
            System.out.println("\n6.-> String charAt() Method: ");
            String strTest = "Strings are immutable";
            char charAtIndex = strTest.charAt(10);
            System.out.println("strTest.charAt(10): "+ charAtIndex);


       //7. Finding a Character  or a SubString in a String
            System.out.println("\n7-->Finding a Character  or a SubString in a String");
            String txt = "Please locate where 'locate' occurs!";
         //7.1 public int indexOf(int ch) --> Returns: the index of the first occurrence of the character in the character sequence represented by object
            System.out.println("Finding character location: "+txt.indexOf('l'));

        //7.2 public int indexOf(int ch, int fromIndex) --> Returns:
        //the index of the first occurrence of the character in the character sequence represented by this object that is greater than or equal to fromIndex, or -1 if the character does not occur.
            System.out.println("Finding character location from index: "+txt.indexOf('l',12));

        //7.3 public int indexOf(String str) --> Returns:the index of the first occurrence of the specified substring, or -1 if there is no such occurrence.
            System.out.println("Finding substring location: "+txt.indexOf("locate"));

        //7.4 public int indexOf(String str, int fromIndex)  --> Returns: the index of the first occurrence of the specified substring, starting at the specified index, or -1 if there is no such occurrence.
            System.out.println("Finding substring location from index: "+txt.indexOf("are",12));

        //7.5 public int lastIndexOf(int ch) --> Returns:
        //the index of the last occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur.
            System.out.println("Finding character location: "+txt.lastIndexOf('l'));

        //7.6 public int lastIndexOf(int ch, int fromIndex)  --> Returns:
        //the index of the last occurrence of the character in the character sequence represented by this object that is less than or equal to fromIndex, or -1 if the character does not occur before that point.
            System.out.println("Finding character location from index: "+txt.lastIndexOf('l',12));

        //7.7 public int lastIndexOf(String str) --> Returns:
        //the index of the last occurrence of the specified substring, or -1 if there is no such occurrence.
            System.out.println("Finding substring location: "+txt.lastIndexOf("locate"));

        //7.8 public int lastIndexOf(String str, int fromIndex) -->Returns:
        //the index of the last occurrence of the specified substring, searching backward from the specified index, or -1 if there is no such occurrence.
            System.out.println("Finding substring location from index: "+txt.lastIndexOf("are",12));

        //8. public boolean contains(CharSequence s) --> Returns true if and only if this string contains the specified sequence of char values.
            System.out.println("\n8-->Contains two Strings");
            String strContains = "Let's check if a substring is a part of String or not";
            boolean isContains  = strContains.contains("or");
            System.out.println("Substring \"or\" is Present: "+isContains );
            System.out.println("Substring \"or\" is Present: "+strContains.contains("Or") );// false  //Case sensitive

        //9. String toCharArray() Method: Converts this string to a new character array.
            //Returns: a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string.
            char[] stringChars = strTest.toCharArray();
            System.out.println("Converts this string to a new character array.: "+stringChars);
            System.out.println("Converts this string to a new character array.: "+Arrays.toString(stringChars)); //With the String we need to use Arrays.toString(stringChars).
            System.out.println(stringChars); //Overloaded Println method that Prints an array of characters and then terminate the line

       //10.1
            System.out.println("10\n public String[] split(String regex) calls method split(regex, 0) ");
            String strSplit = "String array split method";
            String[] strArray = strSplit.split("\\s"); //Splits this string around matches of the given regular expression.
            System.out.println(Arrays.toString(strArray));

       //10.2
            System.out.println("public String[] split(String regex, int limit)");
            String[] s1Array = strSplit.split("\\s",3); //The limit parameter controls the number of times the pattern is applied and therefore affects the length of the resulting array.
                // If the limit n is greater than zero then the pattern will be applied at most n-1 times, the array's length will be no greater than n, and the array's last entry will contain
                // all input beyond the last matched delimiter. If n is non-positive or zero then the pattern will be applied as many times as possible and the array can have any length,and trailing empty strings will be discarded.
            System.out.println(Arrays.toString(s1Array));

        //11.1 public boolean startsWith(String prefix) --> true if the character sequence represented by the argument is a prefix of the character sequence represented by this string; false otherwise.
            // Note also that true will be returned if the argument is an empty string or is equal to this String object as determined by the equals(Object) method.
            System.out.println("\n10.1 --> public boolean startsWith(String prefix)");
            String strStsrtsWith="java string startsWith method";
            System.out.println(strStsrtsWith.startsWith("ja"));  // true
            System.out.println(strStsrtsWith.startsWith("java string"));   // true
            System.out.println(strStsrtsWith.startsWith("Java string"));  // false Since method startsWith is case-sensitive.

            //11.2 strStsrtsWith.startsWith("") will return true
                System.out.println("10.2 true will be returned if the argument is an empty string");
                System.out.println(strStsrtsWith.startsWith("")); //true will be returned if the argument is an empty string

            //11.3 startsWith() throws NullPointerException if null is pass in the parameter of the method.
                System.out.println("10.3 startsWith() throws NullPointerException if null is pass in the parameter of the method.");
                //System.out.println(strStsrtsWith.startsWith(null));

            //11.4 Java String startsWith() method internally calls Java String startsWith(String prefix, int offset) Method
                    System.out.println("10.4 Java String startsWith() method internally calls Java String startsWith(String prefix, int offset) Method");
                // no offset mentioned; hence, offset is 0 in this case.
                    System.out.println(strStsrtsWith.startsWith("a")); // false
                //i.e.
                    System.out.println(strStsrtsWith.startsWith("j",0)); //false

                // offset is 1
                System.out.println(str.startsWith("a",1)); // True

        //12.1
            System.out.println("\n11.1 --> public boolean endsWith(String suffix)");
            String strEndsWith="java string endsWith method";
            System.out.println(strEndsWith.endsWith("d"));//true
            System.out.println(strEndsWith.endsWith("method")); //true

            //12.2 strEndsWith.endsWith("") return true for Empty string
                System.out.println("11.2 true will return if the argument is an empty string because endsWith(CharSequence ch) internally calls startsWith(suffix, value.length - suffix.value.length);");
                System.out.println(strStsrtsWith.endsWith("")); //true

            //12.3 strEndsWith.endsWith("method") internally
                System.out.println("11.3 Method strEndsWith.endsWith(\"method\") internally calls method startsWith(suffix, value.length - suffix.value.length);");
                System.out.println(strStsrtsWith.startsWith("method", strStsrtsWith.length() - "method".length())); //true


        //13.1
            System.out.println("\n13.1 --> public String toLowerCase(): Converts all of the characters in this String to lower case using the rules of the default locale. This is equivalent to calling toLowerCase(Locale.getDefault()).");
            String strLowerCase = "JAVATPOINT HELLO stRIng object";
            String eng = strLowerCase.toLowerCase(); //calls toLowerCase(Locale.getDefault());
            System.out.println(eng);
            //OR
            System.out.println(strLowerCase.toLowerCase(Locale.forLanguageTag("en"))); // en is a language tag for Locale

            String turkish = strLowerCase.toLowerCase(Locale.forLanguageTag("tr")); // It shows i without dot
            System.out.println(turkish);

       //13.2
            System.out.println("\n13.2 --> public String toUpperCase(): Converts all of the characters in this String to upper case using the rules of the default locale. This method is equivalent to toUpperCase(Locale.getDefault()).");
            String strUpperCase = "hello string";
            System.out.println(strUpperCase.toUpperCase()); // calls toUpperCase(Locale.getDefault())
            //OR
            System.out.println(strUpperCase.toUpperCase(Locale.forLanguageTag("en"))); // en is a language tag for Locale

            System.out.println(strUpperCase.toUpperCase(Locale.forLanguageTag("tr"))); // tr is a language tag for Locale and will print I with dot on upper side


        //14.1
            System.out.println("\n14.1 --> public String replace(char oldChar, char newChar): Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.");
            String strRemove = "replace method example";
            System.out.println(strRemove.replace('r','R')); //public String replace(char oldChar, char newChar)

        //14.2
            System.out.println("14.2 --> public String replace(CharSequence target, CharSequence replacement): Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.");
            System.out.println(strRemove.replace("replace", "REPLACE")); //public String replace(CharSequence target, CharSequence replacement)

        //14.3
            System.out.println("14.3 --? replace() method throws the NullPointerException when the replacement or target is null");
            String target = null;
            //System.out.println( strRemove.replace(target,"replace"));

        //14.4
            System.out.println("14.4 --> public String replaceAll(String regex, String replacement): Replaces each substring of this string that matches the given regular expression with the given replacement.");
            String strReplaceall = "Hey, this is ReplaceAll method. It is used to replace any charsequence with target sequence";
            System.out.println(strReplaceall.replaceAll(" is", " was"));

       ///14.5
            System.out.println("14.5 --> public String replaceFirst(String regex, String replacement): Replaces the first substring of this string that matches the given regular expression with the given replacement.");
            String strReplaceFirst = "Hey, this is ReplaceFirst method. It is used to replace only first charsequence with target sequence";
            System.out.println(strReplaceFirst.replaceFirst(" is"," was"));


       //15.1.1
            System.out.println("\n15.1.1 --> public static String join(CharSequence delimiter, CharSequence... elements): Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified delimiter. Note that if an element is null, then \"null\" is added.");
            String joinString1=String.join("-","welcome","to","javatpoint");
            /*delimiter:	the delimiter that separates each element	String type
              elements: 	the elements to join together.	            String type*/
            System.out.println(joinString1);

      //15.1.2
            System.out.println("15.1.2 --> We can use a delimiter to format the string");
            String date = String.join("/","25","06","2018");
            System.out.print(date);
            String time = String.join(":", "12","10","10");
            System.out.println(" "+time);

      //15.2
            System.out.println("15.2--> using null as a delimiter, we get the null pointer exception");
            /*String strJoin = String.join(null, "abc", "bcd", "apple");
            System.out.println(strJoin);*/

     //15.3 However, if the elements that have to be attached with the delimiter are null then, we get the ambiguity. It is because there are two join() methods, and null is
            // acceptable for both types of the join() method. Observe the following example.
            System.out.println("15.3--> Ambiguity error");
            //String strJoin = String.join("India", null); //ambiguity error
            System.out.println(str);

     //15.4 If the elements that have to be attached with the delimiter have some strings, in which a few of them are null, then the null elements are treated as a normal string,
            // and we do not get any exception or error.
            System.out.println("15.4");
            // one of the element is null however it will be treated as normal string
            String strJoin1 = String.join("-", null, " wake up ", " eat ", " write content for JTP ", " eat ", " sleep ");
            System.out.println(strJoin1);

      //15.5
            System.out.println("\n15.5-->public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)");
            List<String> strList = new ArrayList<String>();
            strList.add("w3r");
            strList.add("Join");
            strList.add("Example");
            // joining with comma as delimiter
            String finalStr = String.join(";", strList);
            System.out.println("str - " + finalStr);

      //16
            System.out.println("\n16--> public int compareTo(String anotherString): Compares two strings lexicographically. The comparison is based on the Unicode value of each " +
                    "character in the strings. \nThe character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string. ");
            System.out.println("If the first string is lexicographically greater than the second string, it returns a positive number (difference of character value). If the first string is less than " +
                    "the second string lexicographically, it returns a negative number, and if the first string is lexicographically equal to the second string, it returns 0.");
            System.out.println("i.e. if s1 > s2, it returns positive number  \n" +
                                    "if s1 < s2, it returns negative number  \n" +
                                    "if s1 == s2, it returns 0  ");

            String strCompare1="hello";
            String strCompare2="hello";
            String strCompare3="meklo";
            String strCompare4="hemlo";
            String strCompare5="flag";
            String strCompare6="";
            System.out.println("\"hello\".compareTo(\"hello\"): "+strCompare1.compareTo(strCompare2));//0 because both are equal
            System.out.println("\"hello\".compareTo(\"meklo\"): "+strCompare1.compareTo(strCompare3));//-5 because "h" is 5 times lower than "m"
            System.out.println("\"hello\".compareTo(\"hemlo\"): "+strCompare1.compareTo(strCompare4));//-1 because "l" is 1 times lower than "m"
            System.out.println("\"hello\".compareTo(\"flag\"): "+strCompare1.compareTo(strCompare5));//2 because "h" is 2 times greater than "f"

            System.out.println("\ncompareTo(): empty string");
            System.out.println("When we compare two strings in which either first or second string is empty, the method returns the length of the string. So, there may be two scenarios:");
            System.out.println("1. If first string is an empty string, the method returns a negative\n" +
                                "2. If second string is an empty string, the method returns a positive number that is the length of the first string.");

            System.out.println("\"hello\".compareTo(\"\"): "+strCompare1.compareTo(strCompare6));// O/P: 5
            System.out.println("\"\".compareTo(\"flag\"): "+strCompare6.compareTo(strCompare1));// O/P: -5

            String strCompare7 = "HELLO";
            System.out.println("\"hello\".compareTo(\"HELLO\"): "+strCompare1.compareTo(strCompare7)); // O/P: 32

            System.out.println("\"hello\".compareToIgnoreCase(\"HELLO\"): "+strCompare1.compareToIgnoreCase(strCompare7)); // O/P: 0

        //17
            System.out.println("\n17.1--> public boolean equals(Object anObject): Compares this string to the specified object. The result is true if and only if " +
                            "the argument is not null and is a String object that represents the same sequence of characters as this object.");
            String strEquals1="java";
            String strEquals2="java";
            String strEquals3="JAVA";
            String strEquals4="python";
            System.out.println("\"java\".equals(\"java\"): "+strEquals1.equals(strEquals2));//true because content and case is same
            System.out.println("\"java\".equals(\"JAVA\"): "+strEquals1.equals(strEquals3));//false because case is not same
            System.out.println("\"java\".equals(\"python\"): "+strEquals1.equals(strEquals4));//false because content is not same

            System.out.println("\n17.2--> Compares this String to another String, ignoring case considerations. Two strings are considered equal ignoring case if they are of the " +
                                "same length and corresponding characters in the two strings are equal ignoring case.");
            System.out.println("Two characters c1 and c2 are considered the same ignoring case if at least one of the following is true:\n" +
                                "The two characters are the same (as compared by the == operator)\n" +
                                "1. Applying the method Character.toUpperCase(char) to each character produces the same result\n" +
                                "2. Applying the method Character.toLowerCase(char) to each character produces the same result");
            System.out.println("\"java\".equals(\"JAVA\"): "+strEquals1.equals(strEquals3));//false because case is not same
            System.out.println("\"java\".equalsIgnoreCase(\"JAVA\"): "+strEquals1.equalsIgnoreCase(strEquals3));//true because checking with equalsIgnoreCase

        //18
            System.out.println("\n18.1 --> getBytes() method encodes the string using the default charset of the platform, which is UTF-8.");
            String s1Bytes="ABCDEFG";
            byte[] byteArray1 = s1Bytes.getBytes();
            System.out.println("Convert the string to a byte array using platform's default charset: "+Arrays.toString(byteArray1));

            try {
                byte[] byteArray2 = s1Bytes.getBytes("UTF-8");
                System.out.println("Bytecode conversion using UTF-8: "+Arrays.toString(byteArray2));
                byte[] byteArray3 = s1Bytes.getBytes("UTF-16");
                System.out.println("Bytecode conversion using UTF-16: "+Arrays.toString(byteArray3));
                byte[] byteArray4 = s1Bytes.getBytes("UTF-32");
                System.out.println("Bytecode conversion using UTF-32: "+Arrays.toString(byteArray4));
            } catch (Exception e) {
                System.out.println(e + " encoding is wrong");
            }

      //19.
            System.out.println("\n19--> public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin): Copies characters from this string into the destination character array.\n" +
                    "The first character to be copied is at index srcBegin; the last character to be copied is at index srcEnd-1");
            String  stringFrom = new String("Hello World");
            char[] destChar = {2,3,4,5,6,7};
            stringFrom.getChars(1,4,destChar,0);//Copies characters from this string into the destination character array.
            System.out.println("destchar: "+Arrays.toString(destChar));

      //20.1
            System.out.println("\n20.1-->public static String valueOf(int i): converts different types of values into string. By the help of string valueOf() method, you can convert int to string, " +
                                "long to string, boolean to string, character to string, float to string, double to string, object to string and char array to string.");
            int value=30;
            String strValuesOf1=String.valueOf(value);
            System.out.println("String+int --> concatenation: "+strValuesOf1+10);//concatenating string with 10

     //20.2
            System.out.println("20.2--> converting array and object to string");
            int[] int1 = {1,2,3,4,5,6,7};
            char chr[]={'j','a','v','a'};
            StringProgram1 obj1 = new StringProgram1();
            System.out.println("converting int1[] to String: "+String.valueOf(int1));
            System.out.println("converting chr[] to String with method String.valueOf(chr): "+String.valueOf(chr));
            System.out.println("\"String.valueOf(chr) is equivalent to String.copyValueOf(chr) method\"");
            System.out.println("converting chr[] to String with method String.copyValueOf(chr): "+String.copyValueOf(chr));
            System.out.println("converting obj1 to String: "+String.valueOf(obj1));

     //21
            System.out.println("\n21--> public default IntStream chars(): charSequence method to convert String to IntStream.");
            String strChars = "abcde";

            // use the chars method to get a stream of char values
            IntStream codePointStream = strChars.chars();
            codePointStream.forEach(System.out::println);

     //22.1
            System.out.println("\n22.1--> public int codePointAt(int index): Return the code point value((Unicode code point) of the character at the specified index");
            String strCodePoint = "Hello World";
            //The first character to be copied is at index srcBegin; the last character to be copied is at index srcEnd-1
            System.out.println("strCodePoint.codePointAt(10): "+strCodePoint.codePointAt(10));

     //22.2
            System.out.println("22.2--> public default IntStream codePoints(): an IntStream of Unicode code points from this sequence");
            IntStream codePointIntStream = strCodePoint.codePoints();
            codePointIntStream.forEach(i->System.out.print(i+" "));

     //22.3
            System.out.println("\n22.3--> public int codePointBefore(int index): the Unicode code point value before the given index. The index refers to char values (Unicode code units) and ranges from 1 to length.");
            System.out.println("CodePoint before index o: "+strCodePoint.codePointBefore(1));

     //22.4
            System.out.println("22.4--> public int codePointCount(int beginIndex, int endIndex): returns the \"total number\" of Unicode code points in the specified range.");
            System.out.println("strCodePoint.codePointCount(1,5): "+strCodePoint.codePointCount(1,5));// O/P: 4
    }
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
        //StringBuilder stringBuilderAr
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

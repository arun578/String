package org.learning.java.String;

import java.util.Arrays;

/**
 * Created by  preeti on 5/14/22 at 4:52 PM.
 */
public class ArraysClassReview {
    Object object = new Object();

    public static void main(String[] args) {
        int[] var1 = {2,3,4,5,6};
        int copyTo[] = Arrays.copyOfRange(var1, 0,3);

        /*The toString method for class Object returns a string consisting of the name of the class of which the
        object is an instance, the at-sign character `@', and the unsigned hexadecimal representation of the hash code
        of the object. In other words, this method returns a string equal to the value of:
        getClass().getName() + '@' + Integer.toHexString(hashCode()) */

        System.out.println(var1);
        // Due to above reason we need to parse the array
        for (int iterate: copyTo) {
            System.out.print(iterate);
        }

        char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(helloArray); //This can also print array elements since PrintStream has method to print char[] array
        System.out.println(new String(helloArray));

        String spanLines = "hey let's try span line                ";


        System.out.printf("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s\n", 10.2, 3, "abc");

        String fs;

        String.format("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s", 10.2, 3, "abc");

        //System.out.println(fs);
    }
}

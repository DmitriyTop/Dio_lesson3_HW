package com.ls3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testPositive();
        //testLeftArrayIsEmpty();
        //testLeftArrayIsNull();

    }

    private static void testPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {1, 5, 4, 2, 3, 24, 34, 45, 65, 78, 23, 32};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Merge main = new Merge();
        int[] returnValue = main.mergeArrays(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArray: " + Arrays.toString(expectedArray));

        System.out.println("Test passed? --" + main.compare(returnValue, expectedArray));
    }

    private static void testLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Merge main = new Merge();
        int[] returnValue = main.mergeArrays(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    private static void testLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Merge main = new Merge();
        int[] returnValue = main.mergeArrays(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }
}

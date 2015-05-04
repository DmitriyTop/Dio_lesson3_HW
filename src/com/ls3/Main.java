package com.ls3;

import java.util.Arrays;

public class Main {

    //local code review (vtegza): move to Junit test @ 04.05.15
    public static void main(String[] args) {
        testPositive();
        //testLeftArrayIsEmpty();
        //testLeftArrayIsNull();

    }

    private static void testPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        /* expected for Merge */
//        int[] expectedArray = {1, 5, 4, 2, 3, 24, 34, 45, 65, 78, 23, 32};

        /* expected for innerUnion */
//        int[] expectedArray = {1, 5, 32, 4};

        /* expected for outerUnion */
        int[] expectedArray = {23, 65, 78, 3, 24, 2, 34, 45};

        System.out.println("LeftArray: \n" + Arrays.toString(leftArray));
        System.out.println("RightArray: \n" + Arrays.toString(rightArray));

        /* initialize merge method */
//        Merge main = new Merge();
//        int[] returnValue = main.mergeArrays(leftArray, rightArray);

        /* initialize innerUnion method */
//        InnerUnion main = new InnerUnion();
//        int[] returnValue = main.innerUnionArrays(leftArray, rightArray);

         /* initialize outerUnion method */
        OuterUnion main = new OuterUnion();
        int[] returnValue = main.outerUnionArrays(leftArray, rightArray);

        System.out.println("ReturnValue: \n" + Arrays.toString(returnValue));
        System.out.println("ExpectedArray: \n" + Arrays.toString(expectedArray));

        System.out.println("Test passed? --" + (main.compare(returnValue, expectedArray)));
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

    /* array generation method implementation */
    public static ArrayElement[] generateObjectArray (int[] intArray) {
        ArrayElement[] objectArray = new ArrayElement[intArray.length]; // create our array of objects
        for (int i = 0; i < intArray.length; i++) {                     // cycle to define every array element
            objectArray[i] = new ArrayElement();                        // define type of element as object-type
            objectArray[i].setElementName(String.valueOf(intArray[i])); // redefine Name as String from int array
            objectArray[i].setElementValue(intArray[i]);                // assign name to array object
        }
        return objectArray;
    }

    /* array output method implementation */
    public static void printObjectArray(ArrayElement[] objectArray) {
        System.out.println("{ ");
        for (ArrayElement value: objectArray) {
            System.out.print(value.getElementName());
            System.out.print(" ");
        }
        System.out.println(" }");
    }
}

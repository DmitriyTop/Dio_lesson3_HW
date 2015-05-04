package com.ls3;

import java.util.Arrays;

public class ArrayOperations {

    /* ************* INNER UNION ************* */

    public int[] innerUnionArrays(int[] leftArray, int[] rightArray) {
        int[] resArray = new int[Math.max(leftArray.length,rightArray.length)];
        int totalElementsFoundInRightArray = 0;

        for(int rightArrayElement: rightArray) {
            for(int leftArrayElement: leftArray) {
                if (leftArrayElement == rightArrayElement) {
//                  System.out.println(rightArrayElement);
                    resArray[totalElementsFoundInRightArray] = rightArrayElement;
                    totalElementsFoundInRightArray++;
                }
            }
        }

        System.out.println("resArray " + Arrays.toString(resArray));

        resArray = Arrays.copyOf(resArray, totalElementsFoundInRightArray);
        Arrays.sort(resArray);

        System.out.println("Sorted resArray " + Arrays.toString(resArray));

        /* removal of duplicates */
        int[] temp = new int[leftArray.length + rightArray.length];
        int count = 0;

        for (int index = 0; index < resArray.length-1; index++) {
            if(resArray[index] < resArray[index+1]) {
                temp[count] = resArray[index];
                count++;
            }
            if(index+1 == resArray.length-1) {
                temp[count] = resArray[index+1];
            }
        }

//        System.out.println("temp " + Arrays.toString(temp));

        int[] finalArray = Arrays.copyOf(temp, count+1);
        return finalArray;
    }

    /* ************* MERGE ARRAY ************* */

    public int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int[] resArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);
        int totalElementsFoundInRightArray=0;

        for(int rightArrayElement: rightArray) {
//            System.out.println(rightArrayElement);
            resArray[leftArray.length + totalElementsFoundInRightArray] = rightArrayElement;
            totalElementsFoundInRightArray++;
        }
//        System.out.println("resArray " + Arrays.toString(resArray));
        Arrays.sort(resArray);
//        System.out.println("Sorted resArray " + Arrays.toString(resArray));

        int[] temp = new int[leftArray.length + rightArray.length];
        int count = 0;

        for (int index = 0; index < resArray.length-1; index++) {
            if(resArray[index] < resArray[index+1]) {
                temp[count] = resArray[index];
                count++;
            }
            if(index+1 == resArray.length-1) {
                temp[count] = resArray[index+1];
            }
        }

//        System.out.println("temp " + Arrays.toString(temp));

        int[] finalArray = Arrays.copyOf(temp, count+1);
        return finalArray;
    }

    /* ************* OUTER UNION ************* */

    public int[] outerUnionArrays(int[] leftArray, int[] rightArray) {
        /* right outer join */
        int[] rightOuterArray = new int[rightArray.length];
        int totalElementsFoundInRightArray = 0;

        for(int rightArrayElement: rightArray) {
            int counterOfNonEqual = 0;
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement != leftArrayElement) {
//                  System.out.println(rightArrayElement);
                    counterOfNonEqual++;
                } else break;

                if (counterOfNonEqual == leftArray.length) {
                    rightOuterArray[totalElementsFoundInRightArray] = rightArrayElement;
                    totalElementsFoundInRightArray++;
                }
            }
        }

//        System.out.println(Arrays.toString(rightOuterArray));
        rightOuterArray = Arrays.copyOf(rightOuterArray, totalElementsFoundInRightArray);

        /* left outer join */
        int[] leftOuterArray = new int[leftArray.length];
        int totalElementsFoundInLeftArray = 0;

        for(int leftArrayElement: leftArray) {
            int counterOfNonEqual = 0;
            for(int rightArrayElement: rightArray) {
                if (leftArrayElement != rightArrayElement) {
                    counterOfNonEqual++;
                }
                if (counterOfNonEqual == rightArray.length) {
                    leftOuterArray[totalElementsFoundInLeftArray] = leftArrayElement;
                    totalElementsFoundInLeftArray++;
                }
            }
        }
//        System.out.println(Arrays.toString(leftOuterArray));
        leftOuterArray = Arrays.copyOf(leftOuterArray, totalElementsFoundInLeftArray);

        /* add two arrays together */
        int[] resArray = Arrays.copyOf(leftOuterArray,leftOuterArray.length + rightOuterArray.length);
        int addElementIndex=0;

        for(int rightOuterArrayElement: rightOuterArray) {
            resArray[leftOuterArray.length + addElementIndex] = rightOuterArrayElement;
            addElementIndex++;
        }

//        System.out.println("ResArray " + Arrays.toString(resArray));

        Arrays.sort(resArray);

//        System.out.println("Sorted resArray " + Arrays.toString(resArray));

        /* removal of duplicates */
        int[] temp = new int[resArray.length];
        int count = 0;

        for (int index = 0; index < resArray.length-1; index++) {
            if(resArray[index] < resArray[index+1]) {
                temp[count] = resArray[index];
                count++;
            }
            if(index+1 == resArray.length-1) {
                temp[count] = resArray[index+1];
            }
        }

//        System.out.println("temp " + Arrays.toString(temp));

        int[] finalArray = Arrays.copyOf(temp, count+1);
        return finalArray;
    }

}

package com.ls3;

import java.util.Arrays;

/* OuterUnion realized through sequential leftOuterJoin + rightOuterJoin */
public class OuterUnion implements Comparator {

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

    @Override
    public boolean compare(int[] returnedValue, int[] expectedValue) {
        Arrays.sort(returnedValue);
        Arrays.sort(expectedValue);

        if (Arrays.equals(returnedValue, expectedValue)) {
            return true;
        } else return false;
    }
}
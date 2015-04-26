package com.ls3;

import java.util.Arrays;

public class Merge implements Comparator {

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

    @Override
    public boolean compare(int[] returnedValue, int[] expectedValue) {
        Arrays.sort(returnedValue);
        Arrays.sort(expectedValue);

        if (Arrays.equals(returnedValue, expectedValue)) {
            return true;
        } else return false;
    }
}
/*
        [1,5,4,23,65,32,78]
        [3,5,24,54,1,2,34,45,32]
        res:
        [1,5,4,23,65,32,78, 3,24,54,2,34,45]
*/
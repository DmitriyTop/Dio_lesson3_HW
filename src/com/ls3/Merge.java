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
//        Arrays.sort(resArray);
//        System.out.println("Sorted resArray " + Arrays.toString(resArray));

//        int[] temp = new int[leftArray.length + rightArray.length];
//        temp[0] = resArray[0];

//        for (int index = 0; index < resArray.length-1; index++) {
//            for (int indexNew = index+1; indexNew < resArray.length; indexNew++) {
//                if(resArray[index] < resArray[indexNew]) {
//                    if (index>0 & resArray[index] == resArray[index-1]) {
//                        break;
//                    } else {
//                        temp[index-1] = resArray[index];
//                        break;
//                    }
//                } else {
//                    temp[index] = resArray[indexNew];
//                    System.out.println("temp " + Arrays.toString(temp));
//                    break;
//                }
//            }
//        }

//        System.out.println("temp " + Arrays.toString(temp));

        int[] finalArray = Arrays.copyOf(resArray, leftArray.length + totalElementsFoundInRightArray);
        return finalArray;
    }

    @Override
    public boolean compare(int[] returnedValue, int[] expectedValue) {
        Arrays.sort(returnedValue, 0, returnedValue.length - 1);
        Arrays.sort(expectedValue, 0, expectedValue.length - 1);

        if (returnedValue.equals(expectedValue)) {
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
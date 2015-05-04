package com.ls3;

import java.util.Arrays;

public class InnerUnion {

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

    @Override
    public boolean compare(int[] returnedValue, int[] expectedValue) {
        Arrays.sort(returnedValue);
        Arrays.sort(expectedValue);

        if (Arrays.equals(returnedValue, expectedValue)) {
            return true;
        } else return false;
    }
}
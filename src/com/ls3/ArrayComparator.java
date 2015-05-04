package com.ls3;

import java.util.Comparator;

/**
 * Created by Topchiy on 02.05.15.
 */
public class ArrayComparator implements Comparator<ArrayElement> {

    @Override
    public int compare(ArrayElement element0, ArrayElement element1) {
        return element0.hashCode() - element1.hashCode();
    }
}

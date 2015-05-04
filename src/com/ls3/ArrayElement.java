package com.ls3;

/**
 * Created by Topchiy on 02.05.15.
 */
public class ArrayElement {
    private String elementName;
    private int elementValue;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public int getElementValue() {
        return elementValue;
    }

    public void setElementValue(int elementValue) {
        this.elementValue = elementValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayElement that = (ArrayElement) o;

        if (elementValue != that.elementValue) return false;
        return !(elementName != null ? !elementName.equals(that.elementName) : that.elementName != null);
    }

    @Override
    public int hashCode() {
        int result = elementName != null ? elementName.hashCode() : 0;
        result = 31 * result + elementValue;
        return result;
    }
}

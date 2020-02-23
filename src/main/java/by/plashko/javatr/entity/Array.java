package by.plashko.javatr.entity;

import java.util.Arrays;

public class Array implements Cloneable{
    private static int[] arr;

    public Array() {
    }

    public Array(int[] arr) {
        this.arr = arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public static int[] getArr() {
        return arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
    public Array clone() throws CloneNotSupportedException{

        return (Array) super.clone();
    }
}

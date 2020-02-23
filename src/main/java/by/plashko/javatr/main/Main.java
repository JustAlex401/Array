package by.plashko.javatr.main;

import by.plashko.javatr.Exception.CloneException;
import by.plashko.javatr.Exception.UncorrectedDataException;
import by.plashko.javatr.enter.EnterData;
import by.plashko.javatr.entity.Array;
import by.plashko.javatr.util.ArrayUtil;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Enter number of elements: ");
//        int []arr= EnterData.enterIntArrayFromRandom();
//        Array array=new Array(arr);
//        Array arraySort=ArrayUtil.sort(array);
//        System.out.println(arraySort);
        try {

            int[] arr = EnterData.enterIntArrayFromFile();
            Array array=new Array(arr);
            System.out.println(array);
            Array arraySort=ArrayUtil.quickSort(array);
//            System.out.println(arraySort);
            System.out.println(array);
//            arraySort=ArrayUtil.shelSort(array);
//            System.out.println(arraySort);
        } catch (UncorrectedDataException ex) {
            System.out.println(ex.getMessage());
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone");
        }
    }

}

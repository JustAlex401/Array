package by.plashko.javatr.util;

import by.plashko.javatr.entity.Array;

public class ArrayUtil {
////////////////////////////////////////////////////////////////////////////////////
    public static Array quickSort(Array array) throws CloneNotSupportedException {
        Array clone=array.clone();
        int[] arr = clone.getArr();
        int leftBorder=0;
        int rightBorder=arr.length-1;
        quickSort(arr, leftBorder, rightBorder);
        clone = new Array(arr);
        return clone;
    }
    //O(n log n)
    private static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////
    public static Array shelSort(Array array) {
        int[] arr = array.getArr();
        shelSort(arr);
        Array array1 = new Array(arr);
        return array1;
    }

    private static void shelSort(int []arr){
        int gap = arr.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < arr.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int i = right - gap; i >= 0; i -= gap) {
                    if (arr[i] > arr[i + gap]) {
                        swap(arr, i, i + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }
////////////////////////////////////////////////////////////////////////////////////
    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
//////////////////////////////////////////////////////////////////////////////////

}

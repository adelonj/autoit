import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Arrays.*;

/**
 * Created by delonj on 11/07/2019.
 */
public class GoStudy {

    public static void main(String[] args) {


        //sort(new int[]{1,3,59,0,2,6,5});
        //insertionSort(new int[]{1,3,59,0,2,6,5});
        //insertionSort();
        int [] a1 = {0,2,2};
        int [] a2 = {1,3};
        int [] a3 =  merge(a1,a2);

        int [] result = mergeArrays(a1,a2);



        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(result));

    }

private static int[] merge(int [] a1, int[] a2) {
    int[] a3 = new int[a1.length + a2.length];

    int i = 0, j = 0;

    for (int k = 0; k < a3.length; k++) {

        if (i > a1.length - 1) {
            int a = a2[j];
            a3[k] = a;
            j++;
        } else if (j > a2.length - 1) {
            int a = a1[i];
            a3[k] = a;
            i++;
        } else if (a1[i] < a2[j]) {
            int a = a1[i];
            a3[k] = a;
            i++;
        } else {
            int b = a2[j];
            a3[k] = b;
            j++;
        }
    }
    return a3;
}

    public static int[] mergeArrayss(int[] a1, int[] a2) {

        int c1 = 0;
        int c2 = 0;

        int[] result = new int[a1.length + a2.length];
        int i = 0;

        while (c1 < a1.length || c2 < a2.length) {

            if (c1 == a1.length) {
                result[i] = a2[c2];
                c2++;
            } else if (c2 == a2.length) {
                result[i] = a1[c1];
                c1++;
            } else if (a1[c1] <= a2[c2]) {
                result[i] = a1[c1];
                c1++;
            } else if (a2[c2] <= a1[c1]) {
                result[i] = a2[c2];
                c2++;
            };

            i++;

        };

        return result;
    }


    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, newArray, 0, a1.length);
        System.arraycopy(a2, 0, newArray, a1.length, a2.length);
        Arrays.sort(newArray);
        return newArray;
    }


    /**
     * Сортировка со слиянием
     *
     * @param a1 Массив 1
     * @param a2 Массив 2
     * @return остортированный массив
     */

//    public static int[] mergeArrays(int[] a1, int[] a2) {
//
//    }


    /**
     * Сортировка пузырьком
     * @param arr массив из чисел
     */

    public static void sort(int[] arr) {
        System.out.println("Before: "+Arrays.toString(arr));
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            int temp;

            for (int i=0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }

        }
        System.out.println("After: "+ Arrays.toString(arr));

    }


    /**
     * Сорртировка вставками
     * @param arr массив из чисел
     */

    public static void insertionSort(int[] arr) {
        System.out.println("Before: "+Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            System.out.println("i = " + i);
            System.out.println("current = " + current);

            int j = i - 1;


            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]


            System.out.println("j = " + j);
            System.out.println("arr[j+1] = " + arr[j+1]);
            System.out.println("current = " + current);
            arr[j+1] = current;

            System.out.println("Temp: "+ Arrays.toString(arr));

        }
        System.out.println("After: "+ Arrays.toString(arr));

    }

private static void insertionSort() {
    int[] array = {1,3,59,0,2,6,5};

    System.out.println("Before: "+ Arrays.toString(array));

    for (int left = 0; left < array.length; left++) {
        // Вытаскиваем значение элемента
        int value = array[left];
        // Перемещаемся по элементам, которые перед вытащенным элементом
        int i = left-1;
        for (; i >= 0; i--) {
            // Если вытащили значение меньшее — передвигаем больший элемент дальше
            if (value < array[i]) {
                int max = array[i];
                array[i + 1] = max;
            } else {

                // Если вытащенный элемент больше — останавливаемся
                break;
            }
        }
        // В освободившееся место вставляем вытащенное значение

        array[i + 1] = value;
    }
    System.out.println("After: "+ Arrays.toString(array));
}



    public static int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public static int [] mergeArray(int[] arrayА, int[] arrayB) {

        int[] arrayC = new int[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[i - positionA];
                positionA++;
            } else if (arrayА[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayА[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }

}

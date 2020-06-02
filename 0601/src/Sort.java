import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    static void swap (int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectionSort (int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int pos = i;
            for (int j = i+1; j < arr.length; j++) {
                pos = arr[pos] <= arr[j] ? pos : j;
            }
            swap(arr,pos,i);
        }
    }
    static void bubbleSort (int[] arr) {
        for (int i = arr.length-1; i > 0 ; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && temp < arr[j-1] ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    static void insertSort2(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j >= gap && temp < arr[j-gap]; j -= gap) {
                  arr[j] = arr[j-gap];
            }
            arr[j] = temp;
        }
    }

    static void shellSort(int[] arr) {
        int[] q = {5};
        for (int value : q) {
            insertSort2(arr, value);
        }
    }
    public int count(int[] A, int n) {
        // write code here
        int count = 0;
        for(int i = 1; i < n; i++) {
            int temp = A[i];
            int j = i;
            for(; j > 0 && A[j-1] > temp; j--) {
                A[j] = A[j-1];
                count++;
            }
            A[j] = temp;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,8,25,35,6,18,30,5,15,28};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

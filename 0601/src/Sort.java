import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    static void swap (int[] arr,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
    public static void margeSort(int[] arr,int left, int right) {

        if (left == right) return;
        int mid = (left + right) / 2;
        margeSort(arr,left,mid);
        margeSort(arr,mid+1,right);
        merge(arr,left,mid+1,right);

    }
    public static void merge(int[] arr, int leftPos, int rightPos, int rightBound) {

        int mid = rightPos - 1;
        int[] temp = new int[rightBound - leftPos + 1];
        int k = 0;
        int i = leftPos;
        int j = rightPos;

        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        k = 0;
        while (k < temp.length) arr[leftPos++] = temp[k++];
    }

    public static void quickSort(int[] arr,int left,int right) {

        if (left >= right) return;
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);

    }
    public static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];

        while (left < right) {
            while (arr[left] <= pivot && left < right) left++;
            arr[right] = arr[left];
            while (arr[right] > pivot && left < right) right--;
            arr[left] = arr[right];
        }
        arr[left] = pivot;
        return left;
    }


    public static void main(String[] args) {

        int[] arr = {10,20,8,25,35,6,18,30,5,15,28};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}

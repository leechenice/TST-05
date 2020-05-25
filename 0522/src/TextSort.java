import java.util.Stack;

public class TextSort {

    public static void quickSort2(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            int par = partition(array,left,right);
            if (par > left + 1) {
                stack.push(left);
                stack.push(par-1);
            }
            if (par < right - 1) {
                stack.push(par+1);
                stack.push(right);
            }
        }
    }

    public static void swap(int[] array,int a,int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
     }

    public static void three_num_mid(int[] array,int left,int right) {
        //array[mid] <= array[left] <= array[high]
        int mid = (right+left) / 2;
        if (array[left] > array[right]) {
            swap(array,left,right);
        }
        if (array[left] < array[mid]) {
            swap(array,left,mid);
        }
        if (array[right] < array[mid]) {
            swap(array,right,mid);
        }

    }


    public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] <= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] >= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = tmp;
        return high;
    }

    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        three_num_mid(array,left,right);
        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }


    public static void selectSort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0 ; j--) {
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0 ; j -= gap) {
                if (array[j] > tmp)
                    array[j+gap] = array[j];
                else break;
            }
            array[j+gap] = tmp;
        }
    }
    public static void adjustDown(int[] array,int root,int size) {
        int child = 2 * root + 1;
        while (child < size) {
            if (child+1 < size && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[root]) {
                swap(array,child,root);
                child = 2 * child + 1;
            }else {
                break;
            }
        }
    }
    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)>>1; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void heapSort(int[] array) {
        createHeap(array);
        for (int i = array.length-1; i > 0; i--) {
            swap(array,0,i);
            adjustDown(array,0,i);
        }

    }

    public static  void  shellSort(int[] array) {

        int[] drr = {5,3,1};
        for (int value : drr) {
            shell(array, value);
        }

    }
    public static void mer(int[] array,int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int size = high - low + 1;
        int[] tmp = new  int[size];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= s2) {
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        System.arraycopy(tmp, 0, array, low, size);

    }
    public static void merge(int[] array, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) >>> 1;
        merge(array,low,mid);
        merge(array,mid+1,high);
        mer(array,low,mid,high);

    }
    public static void mergeSort(int[] array) {
        merge(array,0,array.length-1);
    }
    public static void mergeSort2(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            mergeNor(array,gap);
        }
    }

    public static void mergeNor(int[] array,int gap) {
        int[] ret = new int[array.length];
        int k = 0;//ret的下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 :  array.length-1;

        //1、肯定是有两个归并段的
        while (s2 < array.length) {
            //2、对应的s1位置和s2位置进行比较
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                } else {
                    ret[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1 < array.length ? s1 + gap - 1 : array.length - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;

            //3、上述第2步在比较的过程当中，肯定会有一个下标先走完一个归并段

            //4、判断是谁没走完，把剩下的数据拷贝到结果数组当中

            //5、接着确定新的s1,e1,s2,e2
        }
        while (s1 <= e1) {
            ret[k++] = array[s1++];
        }
        System.arraycopy(ret, 0, array, 0, array.length);


    }


}

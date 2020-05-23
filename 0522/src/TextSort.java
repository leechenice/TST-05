public class TextSort {

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

    public static  void  shellSort(int[] array) {

        int[] drr = {5,3,1};
        for (int value : drr) {
            shell(array, value);
        }

    }

}

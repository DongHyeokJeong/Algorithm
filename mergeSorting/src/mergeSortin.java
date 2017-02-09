import java.util.Arrays;

public class mergeSortin {
    public static void main (String [] args) throws Exception {
        int[] sample = new int[] {123, 23, 7, 23, 865, 57, 4, 348};

        merge_sort(sample);

        System.out.print(Arrays.toString(sample));

    }

    public static void merge_sort(int[] arr) {
        int[] arr_temp1 = new int[arr.length/2];
        int[] arr_temp2 = new int[arr.length- arr.length/2];

        if(arr.length > 1) {
            for (int i = 0; i < arr.length; i++) { //divide
                if (i < arr.length / 2) {
                    arr_temp1[i] = arr[i];
                } else {
                    arr_temp2[i - (arr.length / 2)] = arr[i];
                }
            }

            merge_sort(arr_temp1);
            merge_sort(arr_temp2);

            merging(arr_temp1,arr_temp2,arr);
        }
    }

    public static void merging(int[] arrA, int[] arrB, int[] arrC) {
        int i=0;
        int j=0;
        int k=0;

        while(i < arrA.length  || j < arrB.length) {
            if(i >= arrA.length) {
                arrC[k] = arrB[j];
                j++;
                k++;
            }
            else if(j >= arrB.length) {
                arrC[k] = arrA[i];
                i++;
                k++;
            }
            else {
                if(arrA[i] > arrB[j]) {
                    arrC[k] = arrB[j];
                    j++;
                    k++;
                }
                else {
                    arrC[k] = arrA[i];
                    i++;
                    k++;
                }
            }
        }
    }
}

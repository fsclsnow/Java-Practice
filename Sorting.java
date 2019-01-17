import java.util.*;

public class Sorting {
    public static int[] insertSort (int[] chaos){
        for (int j=1; j<chaos.length;j++){
            Integer key = chaos[j];
            int i = j-1;
            while (i>=0 && chaos[i]>key){
                chaos[i+1]=chaos[i];
                i--;
                chaos[i+1]=key;
            }
        }
        return chaos;
    }

    public static int[] mergeSort (int[] list) {
        int len = list.length;
        int mid = len/2;
        int[] firstHalf = new int[mid];
        int[] secHalf = new int[len-mid];
        if (list.length==1){
            return list;}
        else
            for (int i = 0; i<mid;i++){
                firstHalf[i]=list[i];
            }
            for (int i=mid;i<len-mid;i++){
                secHalf[i]=list[i];
            }
            merge(mergeSort(firstHalf),mergeSort(secHalf));
        return list;
    }

    private static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if (left[i]<right[i]){
                result[k]=left[i];
                i++;k++;
            }
            else {
                result[k]=right[k];j++;k++;
            }
        }
        while (i<left.length){
            result[k]=left[i];
            i++;k++;
        }
        while (j<right.length){
            result[k]=right[j];
            j++;k++;
        }
        return result;
    }

    public static void print(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
    public static void main(String[] arg){
        int[] l1 = {3,45,1,6,12,35,41,4,17,8,33,47,15,21,5};
        print(l1);
        print(insertSort(l1));
        print(mergeSort(l1));
    }
}

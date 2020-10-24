package cn.itsource.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date 2020/8/29 0029 9:43
 * @Description: TODO
 * @Version:1.0
 */
public class MaoPao {

    public static void main(String[] args) {
        int [] arr ={122,54,32,11,25,85,31,23};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    replaceArr(arr,j,j+1);
                }
            }
        }
    }

    private static void replaceArr(int[] arr, int i, int j) {
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

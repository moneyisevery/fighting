package cn.itsource.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date 2020/8/29 0029 22:06
 * @Description: TODO
 * @Version:1.0
 */
public class Xuanzepaixu {
    public static void sort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            int index=i;
            for (int j = i+1; j <arr.length ; j++) {
                index=arr[index]<arr[j]?index:j;
            }
            replaceArr(arr,i,index);
        }

    }
    private static void replaceArr(int[] arr, int i, int j) {
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int [] arr ={122,54,32,11,25,85,31,23};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

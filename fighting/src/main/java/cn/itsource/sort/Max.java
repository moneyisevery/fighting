package cn.itsource.sort;

/**
 * @author yb
 * @date 2020/8/29 0029 9:31
 * @Description: TODO
 * @Version:1.0
 */
public class Max {
    public static int getMax(int[]arr,int l,int r){
        if(r==l){
          return arr[r];
        }
        int middle =(l+r)/2;
        int left = getMax(arr, l, middle);
        int right = getMax(arr, middle + 1, r);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        int arr[]={5,36,20,64,21,89};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}

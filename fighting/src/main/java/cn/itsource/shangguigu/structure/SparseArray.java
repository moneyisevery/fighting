package cn.itsource.shangguigu.structure;

/**
 * @author yb
 * @date 2020/11/24 0024 18:39
 * @Description: 二位数组转稀疏数组
 * @Version:1.0
 */
public class SparseArray {

    public static void main(String[] args) {
        //初始化二维数组
        int[][] intss = new int[11][11];
        //在第二行第三列位置
        intss[1][3]=1;
        intss[2][4]=1;
        int[][] transformArr = transformArr(intss);
        for (int[] ints : intss) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        int[][] reverse = reverse(transformArr);
        for (int[] ints : reverse) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }

    /**
     * 二位数组转稀疏数组
     * @param intss
     * @return
     */
    public static int[][] transformArr(int[][] intss){
        int sum =0;
        for (int[] ints : intss) {
            for (int anInt : ints) {
                if (anInt!=0){
                    sum++;
                }
            }
        }
        //稀疏数组  行  列   值
        //         11  11  有效值 sum
        //       第几行 第几列 值是多少
        int[][] newArr = new int[sum + 1][3];
        newArr[0][0]=11;
        newArr[0][1]=11;
        newArr[0][2]=sum;
        int flag =1;
        for (int i = 0; i < intss.length; i++) {
            for (int a = 0; a < intss[i].length; a++) {
                if (intss[i][a]!=0){
                    newArr[flag][0]=i;
                    newArr[flag][1]=a;
                    newArr[flag][2]=intss[i][a];
                    ++flag;
                }
            }
        }
       return  newArr;
    }

    /**
     * 反转成原来二维数组
     * @param newArr
     * @return
     */
    public static int[][] reverse(int [][] newArr){
        int[][] ints = new int[newArr[0][0]][newArr[0][1]];
        for (int i = 0; i <newArr[0][2] ; i++) {
            ints[newArr[i+1][0]][newArr[i+1][1]]=newArr[i+1][2];
        }

        return ints;
    }
}

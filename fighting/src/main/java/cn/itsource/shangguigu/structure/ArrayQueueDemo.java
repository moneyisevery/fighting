package cn.itsource.shangguigu.structure;

import lombok.Data;

import java.util.Scanner;

/**
 * @author yb
 * @date 2020/11/28 0028 9:19
 * @Description: 数组实现队列
 * @Version:1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        //接收输入
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag =true;
        while (flag){
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(add):取出队列元素");
            System.out.println("s(add):显示队列数据");
            System.out.println("e(exit):退出");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("请输入要加入队列的元素!");
                    int value = scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'g':
                    try {
                        System.out.println(arrayQueue.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':scanner.close();
                    flag=false;
                    break;
                case 's':arrayQueue.printQueue();
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}
/**
 * 问题 没有达到复用性!
 */
@Data
class ArrayQueue{
    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * 指向数组头 默认-1
     */
    private int front =-1;
    /**
     * 指向当前数组的最后一个元素
     */
    private int rear =-1;
    /**
     * 用于存放数据  模拟队列
     */
    private int [] ints;


    /**
     * 初始化数组大小
     */

    public  ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        ints=new int[this.maxSize];
    }
    /**
     * 插入元素
     */
    public  void add(int i)  {
        if(rear ==this.maxSize-1){
            System.out.println("当前队列已满不能添加新的元素!");
            return;
        }
        rear++;
        ints[rear]=i;
    }
    /**
     * 取出元素
     */
    public int get() {
        if (front==rear){
            //回到初始指针
            front=-1;
            rear=-1;
            throw new RuntimeException("当前队列中没有元素!");
        }
        front++;
        return ints[front];
    }


}

/**
 * 数组模拟环形队列
 *思路:
 * front 始终指向数组第一位 arr[front]就是队列第一个元素
 * rear  指向队列最后一个元素的后一个位置(数组有效空间maxSIze-1)
 * 队列满时条件  (rear+1)%maxSize=front;
 *
 * 队列有效数据个数 (rear+maxSize-front)%maxSize
 */
class CircleArrayQueue{
    /**
     * 数组最大容量
     */
    private int maxSize;

    private int rear;

    private int front;

    private int[] arr;

    public CircleArrayQueue(int maxSize){
        //初始化
        this.maxSize=maxSize;
        arr=new int[this.maxSize];
    }
    /**
     * 队列是否满
     */
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }
    /**
     * 队列有效个数
     * @return
     */
    public int usedNum(){
        return (rear+maxSize-front)%maxSize;
    }

    public void add(int val){
        if (isFull()){
            System.out.println("当前队列已满不能添加新的元素!");
            return ;
        }
        arr[rear]=val;
        //此时需考虑 当rear+1>=maxsize时  应该取模
        rear=(rear+1)%maxSize;
    }
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("当前队列中没有数据!");
        }
        //需要一个临时变量存储当前front指针的值 返回  再移动front指针
        int temp =arr[front];
        //此时需要考虑 当frot来到maxsize-1-1时  应该指向0
        front=(front+1)%maxSize;
        return temp;
    }

    public void printQueue(){
        if (isEmpty()){
            throw new RuntimeException("当前队列中没有数据!");
        }
        for (int i = front; i <front+usedNum(); i++) {
            //i可能会大于数组长度  需要取模
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }



}
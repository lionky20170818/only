package com.example.only.test.sort;

/**
 * Author: created by liguoliang
 * Date: 2019/4/12 11:41 41
 * Version: 1.0
 * Function: 用于
 */
public class BaseSortTest {
    public static void main(String[] args) {
        //https://www.cnblogs.com/bjh1117/p/8335628.html
//        getMaoPao();
//        getChose();
        getInsertSort();

//        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
//        quickSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }



    }

    ///冒泡
    ////////从第一个数据开始，与第二个数据相比较，如果第二个数据小于第一个数据，则交换两个数据的位置。
    //第一轮大循环最大的数字被移到最右侧
    public static void getMaoPao(){
        int arr[]={1,5,4,2,8};
        System.out.println("排序前");
        for(int num:arr){
            System.out.println(num+"");
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){//-1为了防止溢出
                if(arr[j]>arr[j+1]){
                    int tem = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
        }
        System.out.println("排序后");
        for(int num:arr){
            System.out.println(num+"");
        }

    }

    ///选择  也可以理解为交换排序
    ///从第一个元素开始，分别与后面的元素向比较，找到最小的元素与第一个元素交换位置；
    public static void getChose(){
        int arr[]={1,5,4,2,8};
        System.out.println("排序前");
        for(int num:arr){
            System.out.println(num+"");
        }

        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=minIndex+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        System.out.println("排序后");
        for(int num:arr){
            System.out.println(num+"");
        }

    }

    ///插入  也可以理解为指针排序   比较最左侧
    ///从第一个元素开始，分别与后面的元素向比较，找到最小的元素与第一个元素交换位置；
    public static void getInsertSort(){
        int arr[]={1,5,4,2,8};
        System.out.println("排序前");
        for(int num:arr){
            System.out.println(num+"");
        }

        for(int index = 1; index<arr.length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = arr[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && arr[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                arr[leftindex+1] = arr[leftindex];
                leftindex--;
            }
            arr[leftindex+1] = temp;//把temp放到空位上
        }

        System.out.println("排序后");
        for(int num:arr){
            System.out.println(num+"");
        }

    }

    //快速
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

}

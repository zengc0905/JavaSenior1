package com.zc.exer1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution40
 * @Description 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/17 9:32
 * @Version 1.0
 */
public class Solution40 {
    //方法一：堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        //大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()){
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int[] ints = new int[k];
        int i = 0;
        while (!heap.isEmpty()){
            ints[i++] = heap.poll();
        }
        return ints;
    }


    //方法二：利用快排解决topK问题
    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr,0,arr.length - 1,k);
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }
    public void quickSort(int[] arr,int l,int r,int k){
        if (l >= r) return;
        int pos = partition(arr,l,r);
        int num = pos - l + 1;
        if (num == k) return;
        if (num > k){
            quickSort(arr,l,pos - 1,k);
        }else {
            quickSort(arr,pos + 1,r,k - num);
        }
    }
    public int partition(int[] arr, int l, int r) {
        int rand = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, rand, r);
        int privot = arr[r];
        int m = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] < privot){
                m = m + 1;
                swap(arr,m,i);
            }
        }
        swap(arr,m + 1,r);
        return m + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            System.arraycopy(arr,0,res,0,k);
        }
        return res;
    }
    @Test
    public void test() {
        int[] arr = {3, 2, 1, 4, 5, 7, 3, 2};
        int k = 4;
        int[] res = getLeastNumbers(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

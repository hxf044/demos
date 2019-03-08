package com.hxf.demo.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * 常见的排序
 * Created by Administrator on 2019/2/27.
 */
public class SortFrequently {
    private final static Logger log = LoggerFactory.getLogger(SortFrequently.class);
    /*
    * 冒泡排序
    * 主要思想：两个相邻的对比，然后替换
    * 比较相邻的元素如果第一个比第二个大，就交换它们两个。
    * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数;
    * 针对所有的元素重复以上的步骤，除了最后一个;
    * 重复步骤1〜3，直到排序完成。
    * */
    public static int[] bubbleSort(int[] arr){
        log.info("排序前： arr{}",arr);
        int arrLength = arr.length;
        for(int i = 0; i< arrLength ; i++){
            for (int j=0;j< arrLength-i-1 ;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        log.info("排序后： arr{}",arr);
        return arr;
    }
    //选择排序
    /**
     * 主要思想:记录当前元素下标，然后去比较大小，得到整个数组满足条件的最大下标，然后替换
     * Ñ个记录的直接选择排序可经过N-1趟直接选择排序得到有序结果具体算法描述如下：
     * 初始状态：无序区为[R [1..N]，有序区为空;
     * 第我趟排序（I = 1,2,3，... N-1）开始时，当前有序区和无序区分别为[R [1..i-1]和R（i..n）。该趟排序从当前无序区中 - 选择关键字最小的记录R [k]，将它与无序区的第1个记录R交换，使R [1..i]和R [i + 1 .. n）的分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区;
     * n-1个趟结束，数组有序化了。
     * */
    public static int[] selectionSort(int[] arr){
        log.info("排序前： arr{}",arr);
        int arrLength = arr.length;
        int minIndex = 0;
        int temp = 0;
        for(int i = 0; i < arrLength -1 ; i++){
            minIndex = i;
            for (int j=i+1; j < arrLength  ;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                temp  = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        log.info("排序后： arr{}",arr);
        return arr;
    }
    /**
     * 从第一个元素开始，该元素可以认为已经被排序;
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描;
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置;
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置;
     * 将新元素插入到该位置后;
     * 重复步骤2〜5。
     * */
    public static int[]  insertionSort(int[] arr){
        log.info("排序前： arr{}",arr);
        int  arrLength = arr.length;
        int preIndex = 0;
        int temp = 0;
        for (int i = 1; i < arrLength ; i++){
            preIndex = i-1;
            temp = arr[i];
            while (preIndex >= 0 && arr[preIndex] > temp){
                arr[preIndex+1] = arr[preIndex];
                preIndex-- ;
            }
            arr[preIndex+1] = temp;
        }
        log.info("排序后： arr{}",arr);
        return arr;
    }
    public static int[] shellSort(int[] arr) {
        log.info("排序前： arr{}",arr);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        log.info("gap ：{}",gap);
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                    log.info("j ：{}",j);
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
            log.info("gap1 ：{}",gap);
        }
        log.info("排序后： arr{}",arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4,6,8,7,9,0};
//        shellSort(arr);
        /*Set<Integer> test = new TreeSet<>();
        test.add(2);
        test.add(1);
        test.add(4);
        test.add(3);
        for (Integer obj : test ){
            log.info(obj.hashCode()+"");
        }
        log.info("Set: {}",test);*/
    }
}

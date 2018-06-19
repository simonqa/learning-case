package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all")
public class BubbleSorting {
	//交换位置
	public static void exch(Comparable[] array,int i,int j){
        Comparable temp =array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //比较v是否小于w
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    //打印数组
    public static void show(Comparable[] array){
        for (Comparable num : array) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void sort(Comparable[] array){
        //将数组按升序排列
        //记录是否发生了置换， 0 表示没有发生置换、 1 表示发生了置换
        int isChange;
        //外层循环控制趟数，总趟数为len-1
        int len = array.length;
        for(int i=0;i<len-1;i++){
            //内层循环为当前i趟数 所需要比较的次数
            //每比较一趟就重新初始化为0
            isChange = 0;
            for(int j=0;j<len-i-1;j++){
                if(less(array[j+1], array[j])){
                    exch(array, j, j+1);
                    //如果进到这里面了，说明发生置换了
                    isChange = 1;
                }                          
            }
            //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0) 
                break;
            show(array);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         Comparable[] array = {5, 69, 12, 3, 56, 79, 2, 58, 23};
         sort(array);
         show(array);

    }
}

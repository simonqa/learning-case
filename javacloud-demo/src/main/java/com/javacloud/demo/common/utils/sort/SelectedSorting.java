package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all") 
public class SelectedSorting {

	// 交换位置
	public static void exch(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	// 比较v是否小于w
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	// 打印数组
	public static void show(Comparable[] array) {
		for (Comparable num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	public static void selectSorting(Comparable[] array) {
		// 将数组按升序排列
		int len = array.length; // 计算数组长度
		for (int i = 0; i < len; i++) {
			// 将a[i]和a[i+1...N]中最小的元素交换
			int min = i; // 最小元素的索引
			for (int j = i + 1; j < len; j++) {
				if (less(array[j], array[min]))
					min = j;
				exch(array, i, min);
			}
			show(array);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		selectSorting(array);
		show(array);

	}
}

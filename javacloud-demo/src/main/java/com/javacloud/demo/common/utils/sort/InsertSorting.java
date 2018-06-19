package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all") 
public class InsertSorting {

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

	public static void sort(Comparable[] array) {
		// 将数组按升序排列
		int len = array.length;
		for (int i = 1; i < len; i++) {
			// 将a[i]插入到a[i-1]、a[i-2]、a[i-3]、a[i-4]...之中
			for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
				exch(array, j, j - 1);
			}
			show(array);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		sort(array);
		show(array);

	}
}

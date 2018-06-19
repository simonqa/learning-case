package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all")
public class MergeSorting {
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

	public static void merge(Comparable[] array, int lo, int mid, int hi) {
		// 将a[lo..mid]和a[mid+1..hi]归并
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制到aux[lo..hi]
			aux[k] = array[k];
		for (int k = lo; k <= hi; k++) // 归并回到a[lo..hi]
			if (i > mid)
				array[k] = aux[j++];
			else if (j > hi)
				array[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				array[k] = aux[j++];
			else
				array[k] = aux[i++];
	}
	// 归并所需的辅助数组
	private static Comparable[] aux;
	public static void sort(Comparable[] array) {
		aux = new Comparable[array.length]; // 一次性分配空间
		sort(array, 0, array.length - 1);
	}
	public static void sort(Comparable[] array, int lo, int hi) {
		// 将数组按a[lo..hi]排列
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(array, lo, mid); // 将左半边排序
		sort(array, mid + 1, hi); // 将右半边排序
		merge(array, lo, mid, hi); // 归并结果
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		sort(array);
		show(array);
	}
}

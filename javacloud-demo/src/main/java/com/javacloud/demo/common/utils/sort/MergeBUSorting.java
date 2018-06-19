package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all")
public class MergeBUSorting {
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
		// 进行lgN次两两归并
		int N = array.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz += sz) // sz子数组大小
			for (int lo = 0; lo < N - sz; lo += sz + sz) // lo：子数组索引
				merge(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		sort(array);
		show(array);
	}
}

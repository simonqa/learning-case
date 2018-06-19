package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all")
public class QuickSorting {
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

	// 快速排序的切分
	private static int partition(Comparable[] array, int lo, int hi) {
		// 将数组切分为a[lo..i-1],a[i],a[i+1..hi]
		int i = lo, j = hi + 1; // 左右扫描指针
		Comparable v = array[lo]; // 切分元素
		while (true) {
			// 扫描左右，检查扫描是否结束并交换元素
			while (less(array[++i], v))
				if (i == hi)
					break;
			while (less(v, array[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(array, i, j);
		}
		exch(array, lo, j); // 将v = a[j]放入正确的位置
		return j; // a[lo..j-1] <= a[j] <= a[j+1..hi]达成
	}
	
	public static void sort(Comparable[] array) {
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = array[lo];
		while (i <= gt) {
			int cmp = array[i].compareTo(v);
			if (cmp < 0)
				exch(array, lt++, i++);
			else if (cmp > 0)
				exch(array, i, gt--);
			else {
				i++;
			}
			// 此时a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
			sort(array, lo, lt - 1); // 将左半部分a[lo..j-1]排序
			sort(array, gt + 1, hi); // 将右半部分a[j+1..hi]排序
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		sort(array);
		show(array);
	}
}

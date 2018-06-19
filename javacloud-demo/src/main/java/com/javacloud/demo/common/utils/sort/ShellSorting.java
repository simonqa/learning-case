package com.javacloud.demo.common.utils.sort;

@SuppressWarnings("all")
public class ShellSorting {
	// 交换位置
	public static void exch( Comparable[] array, int i, int j) {
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
		int h = 1;
		while (h < len / 3)
			h = 3 * h + 1; // 1，4，13，40，121，364，1093...
		while (h >= 1) {
			// 将数组变为h有序
			for (int i = h; i < len; i++) {
				// 将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...之中
				for (int j = i; j >= h && less(array[j], array[j - h]); j -= h)
					exch(array, j, j - h);
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] array = { 5, 69, 12, 3, 56, 79, 2, 58, 23 };
		sort(array);
		show(array);
	}
}

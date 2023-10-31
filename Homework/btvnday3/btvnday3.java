package btvnday3;

import java.util.Arrays;
import java.util.Scanner;

public class btvnday3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = nhapDaySo();
//		
//		System.out.println("Kiem tra dieu kien:");
//		System.out.println(kiemTraDieuKien(arr));
		
		int[] arr = {5,2,8,6,1,3,7,9,4};
		
		heapSort(arr, arr.length);
		System.out.println("Day so sau khi sap xep la:");
		printArray(arr);

	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectionSort(int[] arr, int len) {
		for (int i =  0; i < len-1; i ++) {
			int min_i = i;
    		for (int j = i+1; j < len; j++) {
    			if (arr[j] < arr[min_i]) min_i = j;
    		}
    		swap(arr, i, min_i);
    	}
		
	}
	public static void insertionSort(int[] arr, int len) {
		for (int i = 1; i < len; i++) {
			int key = i;
			for (int j = i-1; j >= 0; j--) {
				if (arr[key] < arr[j]) {
					swap(arr, key, j);
					key = j;
				} else break;
			}
		}
	}
	
	public static void bubbleSort(int[] arr, int len) {
		for (int i =  0; i < len; i ++) {
    		for (int j = 0; j < len-1-i; j++) {
    			if (arr[j] > arr[j+1]) {
    				swap(arr, j, j+1);
    			}
    		}
    	}	
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			// tim vi tri trung gian
			int m = l + (r-l)/2;
			// de qui
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			// ghep 2 mang da dc sap xep
			merger(arr, l, m, r);
		}
	}
	
	public static void merger(int[] arr, int l, int m, int r) {
		// tao 2 mang con
 		int len1 = m - l + 1;
		int len2 = r - m;
		int[] arr1 = new int[len1];
		int[] arr2 = new int[len2];
		
		for (int i = 0; i < len1; i++)
            arr1[i] = arr[l + i];
        for (int j = 0; j < len2; j++)
            arr2[j] = arr[m + 1 + j];
        
        // merge 2 day so theo thu tu tu nho den lon
        // 2 mang con mac dinh da dc sap xep vi ham de quy chia nho mang toi muc nho nhat
        int i = l, i1 = 0, i2 = 0;
        
        while (i1 < len1 && i2 < len2) {
			if (arr1[i1] < arr2[i2]) {
				arr[i] = arr1[i1];
				i1++;
			} else {
				arr[i] = arr2[i2];
				i2++;		
			}
			i++;
		}
        
        // sap chep phan con lai cua 1 trong 2 mang
        // chi co toi da 1 trong 2 vong lap dc chay
        while (i1 < len1) {
            arr[i] = arr1[i1];
            i1++;
            i++;
        }
        
        while (i2 < len2) {
            arr[i] = arr2[i2];
            i2++;
            i++;
        }    
	}

	
	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			// tim vi tri cua gia tri trung gian
			int m = partition(arr, l, r);
			// de qui
			quickSort(arr, l, m-1);
			quickSort(arr, m+1, r);
		}
	}
	
	public static int partition(int[] arr, int l, int r) {
		// lay gia tri dau tien lam trung gian
		int pi = arr[l];
		// danh dau vi tri
		int index = l;
		// chuyen cac gia tri nho hon gia tri trung gian ve cung 1 phia
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < pi) {
				swap(arr, i, index+1);
				index++;
			}
		}
		// chuyen gia tri trung gian vao giua
		swap(arr, l, index);
		// tra ve vi tri cua gia tri trung gian
		return index;
	}
	
	public static void heapSort(int[] arr, int len) {
		// tao cay max heap
		for (int i = len/2; i >= 0; i--) {
			heapify(arr, len, i);
		}
		// trong max heap, root luon lon nhat
		// chuyen node lon nhat ve cuoi, node cuoi thay the vi tri root
		// sau do tim vi tri dung cua root moi
		for (int i = len - 1; i >= 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}
	
	public static void heapify(int[] arr, int len, int index) {
		int largest = index;
		int l = 2 * index + 1;
		int r = 2 * index +2;
		// tim node lon nhat
		if (l < len && arr[l] > arr[largest]) largest = l;
		if (r < len && arr[r] > arr[largest]) largest = r;
		// chuyen node lon nhat len lam root
		if (largest != index) {
			swap(arr, largest, index);
			heapify(arr, len, largest);
		}
	}
	
	public static int[] nhapDaySo() {
		Scanner sc = new Scanner(System.in); 	
        System.out.println("Day so co bao nhieu phan tu:");
        int n = sc.nextInt();
        System.out.println("Nhap cac phan tu cua day so:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
	}
	
	public static String kiemTraDieuKien(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
				return "Dieu kien thoat xay ra!";
			}
		}
		return "Dieu kien thoat khong xay ra!";
	}
}

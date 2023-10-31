package btvnday2;

import java.util.Scanner;

public class btvnday2 {
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("Day so co bao nhieu phan tu:");
        int n = sc.nextInt();
        
        System.out.println("Nhap cac phan tu cua day so:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        // In ra day so vua nhap
        int sum = 0; // tinh tong cua day so
        System.out.println("Day so vua nhap co " + n + " phan tu: ");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + arr[i]);
			sum += arr[i];
		}
		System.out.println();
		
        // In ra tong cua day so
        System.out.println("Tong cua day so la: " + sum);
        sc.close();
    }
}

package com.example.commom;

public class DataSecUtils {
	/**
	* @param args
	*/
	public static void main(String[] args) {


	System.out.println(System.currentTimeMillis()); // 毫秒
	System.out.println(getmicTime());
	System.out.println(System.currentTimeMillis()); // 毫秒
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	System.out.println(getmicTime());
	}
	/**
	* @return返回微秒
	*/
	public static Long getmicTime() {
	Long cutime = System.currentTimeMillis() * 1000; // 微秒
	Long nanoTime = System.nanoTime(); // 纳秒
	return cutime + (nanoTime - nanoTime / 1000000 * 1000000) / 1000;
	}
}

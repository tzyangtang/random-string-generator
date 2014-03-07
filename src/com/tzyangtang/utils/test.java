package com.tzyangtang.utils;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String adSetting = "ADMOB";
		String[] adPriorities = adSetting.split("\\|");
		System.out.println((adPriorities == null) ? "Is null" : "Not null");
		System.out.println("length=" + adPriorities.length);
		for (int i = 0; i < adPriorities.length; i++)
			System.out.println("i=" + i + ",value=" + adPriorities[i]);
	}

}

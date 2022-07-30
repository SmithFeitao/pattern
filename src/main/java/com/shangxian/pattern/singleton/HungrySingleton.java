package com.shangxian.pattern.singleton;

/**
 * @author: taofei
 * @describe: 饿汉式1
 * @date 2022/7/30 11:25 AM
 * @since: 1.1.0
 */
public class HungrySingleton {

	private static HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return hungrySingleton;
	}


	public static void main(String[] args) {
		System.out.println(HungrySingleton.getInstance());
	}
}

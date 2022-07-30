package com.shangxian.pattern.singleton.hungry;
/**
 * @author: taofei
 * @describe: 饿汉式2
 * @date 2022/7/30 11:25 AM
 * @since: 1.1.0
 */
public class HungrySingletonV2 {

	private static HungrySingletonV2 hungrySingleton;

	private HungrySingletonV2() {
	}

	static {
		hungrySingleton = new HungrySingletonV2();
	}

	public static HungrySingletonV2 getInstance() {
		return hungrySingleton;
	}


	public static void main(String[] args) {
		System.out.println(HungrySingletonV2.getInstance());
	}
}

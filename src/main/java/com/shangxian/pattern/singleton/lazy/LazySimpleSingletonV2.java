package com.shangxian.pattern.singleton.lazy;

/**
 * @author: taofei
 * @describe: 简单懒汉式单例
 * @date 2022/7/30 11:29 AM
 * @since: 1.1.0
 */
public class LazySimpleSingletonV2 {

	private static LazySimpleSingletonV2 instance;

	public LazySimpleSingletonV2() {
	}

	public synchronized static LazySimpleSingletonV2 getInstance() {
		if (instance == null) {
			instance = new LazySimpleSingletonV2();
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " create:" + LazySimpleSingletonV2.getInstance());
			}, "thread-" + i).start();
		}
	}

}

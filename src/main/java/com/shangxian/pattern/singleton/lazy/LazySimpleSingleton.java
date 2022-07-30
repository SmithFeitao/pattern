package com.shangxian.pattern.singleton.lazy;

/**
 * @author: taofei
 * @describe: 简单懒汉式单例
 * @date 2022/7/30 11:29 AM
 * @since: 1.1.0
 */
public class LazySimpleSingleton {

	private static LazySimpleSingleton instance;

	public LazySimpleSingleton() {
	}

	public static LazySimpleSingleton getInstance() {
		if (instance == null) {
			instance = new LazySimpleSingleton();
		}
		return instance;
	}


	public static void main(String[] args) {

		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " create:" + LazySimpleSingleton.getInstance());
		}, "thread-" + 1).start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " create:" + LazySimpleSingleton.getInstance());
		}, "thread-" + 2).start();
	}
}

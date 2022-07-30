package com.shangxian.pattern.singleton.threadlocal;

public class ThreadLocalSingleton {

	private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstances =
			new ThreadLocal<ThreadLocalSingleton>() {

				@Override
				protected ThreadLocalSingleton initialValue() {
					return new ThreadLocalSingleton();
				}
			};

	private ThreadLocalSingleton() {
	}

	public static ThreadLocalSingleton getInstance() {
		return threadLocalInstances.get();
	}

	public static void main(String[] args) {
		// main线程
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		// 多线程
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
				System.out.println(instance);
			}, "thread-" + i).start();
		}
	}
}

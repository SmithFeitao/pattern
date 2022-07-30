package com.shangxian.pattern.singleton.lazy;

/**
 * @author: taofei
 * @describe: 双层检查锁
 * @date 2022/7/30 12:03 PM
 * @since: 1.1.0
 * 优点：线程安全 性能高
 * 缺点：代码可读性查
 */
public class DoubleCheckSingleton {

	// 指令重排序问题
	// DoubleCheckSingleton instance 分配内存
	// new DoubleCheckSingleton()创建问题
//	private static volatile DoubleCheckSingleton instance;
	private static DoubleCheckSingleton instance;

	public DoubleCheckSingleton() {
	}

//	public static DoubleCheckSingleton getInstance() {
//		synchronized (DoubleCheckSingleton.class) {
//			if (instance == null) {
//				instance = new DoubleCheckSingleton();
//			}
//		}
//		return instance;
//	}

//	public static DoubleCheckSingleton getInstance() {
//		if (instance == null) {
//			synchronized (DoubleCheckSingleton.class) {
//				instance = new DoubleCheckSingleton();
//			}
//		}
//		return instance;
//	}

	public static DoubleCheckSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " create:" + DoubleCheckSingleton.getInstance());
			}, "thread-" + i).start();
		}
	}
}

package com.shangxian.pattern.singleton.lazy;

public class LazyStaticInnerSingleton {

	private LazyStaticInnerSingleton() {
		// 防止反射访问
		throw new RuntimeException("非法访问");
	}

	private static LazyStaticInnerSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		private static final LazyStaticInnerSingleton INSTANCE = new LazyStaticInnerSingleton();
	}
}

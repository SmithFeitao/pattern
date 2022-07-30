package com.shangxian.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

public class LazyStaticInnerSingletonTest {

	public static void main(String[] args) throws Exception{
		Class<?> clazz = LazyStaticInnerSingleton.class;
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
		declaredConstructor.setAccessible(true);
		Object o = declaredConstructor.newInstance();
		System.out.println(o);
	}
}

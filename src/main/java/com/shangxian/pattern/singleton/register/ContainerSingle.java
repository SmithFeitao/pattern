package com.shangxian.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingle {

	private ContainerSingle() {
	}

	private static Map<String, Object> ioc = new ConcurrentHashMap<>();

	public static Object getInstance(String className) {
		if (ioc.get(className) == null) {
			Object o = null;
			try {
				o = Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			ioc.put(className, o);
			return o;
		} else {
			return ioc.get(className);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				Object instance = ContainerSingle.getInstance("com.shangxian.pattern.singleton.register.ContainerSingle");
				System.out.println(instance);
			}, "thread-" + i).start();
		}

	}
}

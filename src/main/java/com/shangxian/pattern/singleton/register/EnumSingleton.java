package com.shangxian.pattern.singleton.register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingleton {
	INSTANCE;
	private Object data;

	private static EnumSingleton getInstance() {
		return INSTANCE;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static void main(String[] args) throws Exception {
//		EnumSingleton instance = EnumSingleton.getInstance();
//		instance.setData(new Object());
		Class<EnumSingleton> enumSingletonClass = EnumSingleton.class;
		Constructor<EnumSingleton> declaredConstructor = enumSingletonClass.getDeclaredConstructor(null);
		EnumSingleton enumSingleton = declaredConstructor.newInstance(null);
	}
}

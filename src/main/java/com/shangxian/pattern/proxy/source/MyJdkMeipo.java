package com.shangxian.pattern.proxy.source;

import com.shangxian.pattern.proxy.staticproxy.Person;
import com.shangxian.pattern.proxy.staticproxy.Zhangsan;

import java.lang.reflect.Method;

public class MyJdkMeipo implements MyInvocationHandler {
	private Person person;

	public Person getInstance(Person person) {
		this.person = person;
		Class<? extends Person> clazz = person.getClass();
		return (Person) MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(this.person, args);
		after();
		return result;
	}

	private void before() {
		System.out.println("开始");
	}

	private void after() {
		System.out.println("结束");
	}

	public static void main(String[] args) {
		MyJdkMeipo jdkMeipo = new MyJdkMeipo();
		Person instance = jdkMeipo.getInstance(new Zhangsan());
		instance.findLove();
	}
}

package com.shangxian.pattern.proxy.jdkproxy;

import com.shangxian.pattern.proxy.staticproxy.Person;
import com.shangxian.pattern.proxy.staticproxy.ZhangLaoSan;
import com.shangxian.pattern.proxy.staticproxy.Zhangsan;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeipo implements InvocationHandler {
	private Person person;

	public Person getInstance(Person person) {
		this.person = person;
		Class<? extends Person> clazz = person.getClass();
		return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
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
		JdkMeipo jdkMeipo = new JdkMeipo();
		Person instance = jdkMeipo.getInstance(new Zhangsan());
		instance.findLove();
	}
}

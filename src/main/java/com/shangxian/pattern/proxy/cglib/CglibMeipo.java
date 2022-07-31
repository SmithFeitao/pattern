package com.shangxian.pattern.proxy.cglib;

import com.shangxian.pattern.proxy.staticproxy.Person;
import com.shangxian.pattern.proxy.staticproxy.Zhangsan;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {
	private Person person;


	public Object getInstance(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		before();
		Object result = methodProxy.invokeSuper(o, objects);
		after();
		return result;
	}

	private void before() {
		System.out.println("before");
	}

	private void after() {
		System.out.println("after");
	}

	public static void main(String[] args) {
		CglibMeipo cglibMeipo = new CglibMeipo();
		Zhangsan instance =(Zhangsan) cglibMeipo.getInstance(Zhangsan.class);
		instance.findLove();
	}
}

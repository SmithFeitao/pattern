package com.shangxian.pattern.proxy.source;

import java.lang.reflect.Method;

public interface MyInvocationHandler {

	Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}

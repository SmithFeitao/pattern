package com.shangxian.pattern.proxy.source;

import com.shangxian.pattern.proxy.staticproxy.Person;
import com.shangxian.pattern.proxy.staticproxy.Zhangsan;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyJdkProxyTest {

	public static void main(String[] args) throws Exception {
//		byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
//		FileOutputStream os = null;
//		try {
//			os = new FileOutputStream("./$Porxy.class");
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//		try {
//			os.write(bytes);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		MyJdkMeipo myJdkMeipo = new MyJdkMeipo();
		Person zhangsan = myJdkMeipo.getInstance(new Zhangsan());
		zhangsan.findLove();
	}
}

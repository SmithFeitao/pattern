package com.shangxian.pattern.proxy.source;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
	public static Object newProxyInstance(MyClassLoader classLoader,
	                                      Class<?>[] interfaces,
	                                      MyInvocationHandler h) {
		// java 文件内容生成
		String src = generateSrc(interfaces);
		System.out.println(src);
		// 创建。java文件
		try {
			String filePath = MyProxy.class.getResource("").getPath();
			File f = new File(filePath + "$Proxy0.java");
			FileWriter fileWriter = new FileWriter(f);
			fileWriter.write(src);
			fileWriter.flush();
			fileWriter.close();
			// 编译.class
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manager.getJavaFileObjects(f);
			JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
			// 生成 .class文件加载到JVM中
			Class<?> clazz = classLoader.findClass("$Proxy0");
			Constructor constructor = clazz.getConstructor(MyInvocationHandler.class);
			//
			return constructor.newInstance(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String generateSrc(Class<?>[] interfaces) {
		StringBuilder sb = new StringBuilder();
		sb.append("package com.shangxian.pattern.proxy.source;");
		sb.append("import com.shangxian.pattern.proxy.staticproxy.Person;\n" +
						"import com.shangxian.pattern.proxy.source.MyInvocationHandler;\n" +
						"import java.lang.reflect.*;\n" +
						"import java.lang.reflect.UndeclaredThrowableException;\n")
				.append("public final class $Proxy0 implements " + interfaces[0].getName() + "{\n")
				.append("MyInvocationHandler h;")
				.append("\n")
				.append("public $Proxy0(MyInvocationHandler h){\n")
				.append("this.h = h;\n")
				.append("}\n");
		for (Method method : interfaces[0].getMethods()) {
//			StringBuilder paramNames = new StringBuilder();
//			StringBuilder paramValues = new StringBuilder();
//			StringBuilder paramClasses = new StringBuilder();
			sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){\n")
					.append("try {\n")
					.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{});\n")
					.append("this.h.invoke(this,m,new Object[]{});\n")
					.append("return;\n")
					.append("} catch(Error e){} catch(Throwable throwable){throw new UndeclaredThrowableException(throwable);}")
					.append("}}");
		}
		return sb.toString();
	}
}

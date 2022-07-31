package com.shangxian.pattern.proxy.source;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class MyClassLoader extends ClassLoader {
	private File classPathFile;

	public MyClassLoader() {
		this.classPathFile = new File(MyClassLoader.class.getResource("").getPath());
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = MyClassLoader.class.getPackage().getName() + "." + name;
		if (classPathFile != null) {
			// /Users/taofei/IdeaProjects/pattern/target/classes/com/shangxian/pattern/proxy/source/$Proxy0.class
			// /Users/taofei/IdeaProjects/pattern/target/classes/com/shangxian/pattern/proxy/source/$Proxy0.class
//			File classFile = new File("/Users/taofei/IdeaProjects/pattern/target/classes/com/shangxian/pattern/proxy/source/$Proxy0.class");
			File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
			if (classFile.exists()) {
				FileInputStream in = null;
				try {
					in = new FileInputStream(classFile);
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte[] buf = new byte[1014];
				int len;
				try {
					while ((len = in.read(buf)) != -1) {
						out.write(buf, 0, len);
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				System.out.println(className);
				return defineClass(className, out.toByteArray(), 0, out.size());
			}
		}
		return null;
	}
}

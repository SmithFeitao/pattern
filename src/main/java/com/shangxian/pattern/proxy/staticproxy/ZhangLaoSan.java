package com.shangxian.pattern.proxy.staticproxy;

public class ZhangLaoSan implements Person {
	private Zhangsan zhangsan;

	public ZhangLaoSan() {
	}

	public ZhangLaoSan(Zhangsan zhangsan) {
		this.zhangsan = zhangsan;
	}

	@Override
	public void findLove() {
		System.out.println("帮儿子找媳妇");
		zhangsan.findLove();
	}


	public static void main(String[] args) {
		ZhangLaoSan zhangLaoSan = new ZhangLaoSan(new Zhangsan());
		zhangLaoSan.findLove();
	}
}

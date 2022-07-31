package com.shangxian.pattern.builder;

import com.alibaba.fastjson.JSON;

public class User {

	private Long id;
	private String name;
	private Integer age;

	public User() {
	}

	public User(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static UserBuilder builder(){
		return new UserBuilder();
	}

	public static class UserBuilder {
		private Long id;
		private String name;
		private Integer age;

		public UserBuilder id(final Long id){
			this.id=id;
			return this;
		}

		public User builder() {
			return new User(this.id, this.name, this.age);
		}
	}

	public static void main(String[] args) {
		User user = User.builder()
				.id(1L)
				.builder();
		System.out.println(JSON.toJSONString(user));
	}
}

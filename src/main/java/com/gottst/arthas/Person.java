package com.gottst.arthas;

/**
 * @author: Administrator
 * @date: 2020/10/18 22:55
 * @modify: 2020/10/18 22:55
 * @description:
 */
public class Person {

	private String name;

	private Integer age;

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

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

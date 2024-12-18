package com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception{
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射给name和age字段赋值:
		Class class1 = p.getClass();
		Field fieldName = class1.getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(p, name);
		Field fieldAge = class1.getDeclaredField("age");
		fieldAge.setAccessible(true);
		fieldAge.set(p, age);
		
		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}

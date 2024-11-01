package com.itranswarp.learnjava;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String[] fields = { "name", "position", "salary" };
		String table = "employee";
		String select = buildSelectSql(table, fields);
		System.out.println(select);
		System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
	}

	static String buildSelectSql(String table, String[] fields) {
		// TODO:
		StringJoiner sj = new StringJoiner(", ","SELECT "," FROM ");
		for(String s1:fields) {
			sj.add(s1);
		}
		
		return sj.toString() + table;
	}

}

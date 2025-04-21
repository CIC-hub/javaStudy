package Java8特性;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Main13Optional {
	
	//创建Optional类对象
	@Test
	public void test1() {
		//Optional.of(T t)创建一个Optional实例，t必须非空
		//Optional.empty()创建一个空的Optional实例
		//Optional.ofNullable(T t)t可以为null
		Girl girl = new Girl();
//		girl = null;//NullPointerException
		Optional<Girl> optional1 = Optional.of(girl);
		System.out.println(optional1);
		
		Girl girl2 = new Girl();
		girl2 = null;
		Optional<Girl> optional2 = Optional.ofNullable(girl2);
		System.out.println(optional2);
	}
	
	@Test
	public void test2() {
		Boy boy = new Boy();
		//boy不为空，girl为空
		String girlName = getGirlName1(boy);
		System.out.println(girlName);
	}
	
	@Test
	public void test3() {
		Boy boy = new Boy();
		boy = null;
		//boy为空
		String girlName = getGirlName1(boy);
		System.out.println(girlName);	
	}
	
	public String getGirlName1(Boy boy) {
//		return boy.getGirl().getName();
//		//空指针异常：boy为空/boy不为空，girl为空
		
		//传统方法处理空指针
		if (boy != null) {
			Girl girl = boy.getGirl();
			if (girl != null) {
				return girl.getName();
			}
		}
		return null;
	}
	
	@Test
	public void test4() {
		Boy boy = new Boy();
		//boy不为空，girl为空
		String girlName = getGirlName2(boy);
		System.out.println(girlName);
		
		boy = null;
		//boy为空
		String girlName2 = getGirlName2(boy);
		System.out.println(girlName2);
		
		boy = new Boy(new Girl("c"));
		String girlName3 = getGirlName2(boy);
		System.out.println(girlName3);
	}
	
	public String getGirlName2(Boy boy) {
		Optional<Boy> boyOptional = Optional.ofNullable(boy);
		Boy boy2 = boyOptional.orElse(new Boy(new Girl("a")));
		//boy2一定非空
		
		Girl girl = boy2.getGirl();
		Optional<Girl> girlOptional = Optional.ofNullable(girl);
		Girl girl2 = girlOptional.orElse(new Girl("b"));
		//girl2一定非空

		return girl2.getName();
	}
}

class Boy{
	private Girl girl;

	@Override
	public String toString() {
		return "Boy [girl=" + girl + "]";
	}

	public Boy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boy(Girl girl) {
		super();
		this.girl = girl;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}
	
}

class Girl{
	private String name;

	public Girl() {
		
	}
	public Girl(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}
}

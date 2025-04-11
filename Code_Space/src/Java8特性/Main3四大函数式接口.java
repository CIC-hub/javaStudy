package Java8特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class Main3四大函数式接口 {

    @Test
	public void test1() {
    	func1(100,a -> System.out.println("money:"+a));
    }
    public void func1(double money,Consumer<Double> consumer) {
    	consumer.accept(money);
    }
    
    @Test
    public void test2() {
		List<String> list = Arrays.asList("北京","天津","京京");
		List<String> list2 = filterString(list, s -> s.contains("京"));
		System.out.println(list2);
    }
    public List<String> filterString(List<String> list,Predicate<String> pre) {
    	ArrayList<String> filterList = new ArrayList<>();
    	for (String string : list) {
			if (pre.test(string)) {
				filterList.add(string);
			}
		}
    	return filterList;
    }
}

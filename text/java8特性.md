### 1 Lambda表达式

**Lambda表达式的本质：函数式接口的实例**

**要求接口只有一个抽象方法（函数式接口）**

#### 1.1 格式

```java
->		  //Lambda操作符
->左边	//接口中抽象方法的形参列表
->右边	//重写的抽象方法的方法体
```

#### 1.2 使用

**使用匿名函数表示的，都可以用Lambda表达式**

**Lambda表达式的形参类型可省，一个参数时()可省；**

**Lambda体用{}包裹，一条语句时{}可省（return语句时要省略return）**

```java
//1.无参，无返回值
Runnable runnable = () -> {System.out.println("test1");};
//2.一个参数，无返回值 
Consumer<String> consumer = (String s) -> {System.out.println(s);};
//3.数据类型可省略，可有编译器推断，“类型推断”
Consumer<String> consumer = (s) -> {System.out.println(s);};
//4.只要一个参数时，参数的小括号可省略
Consumer<String> consumer = s -> {System.out.println(s);};
//5.可以多参数、多语句、返回值
Comparator<Integer> comparator = (o1,o2) -> {
    System.out.println(o1);
    System.out.println(o2);
    return o1.compareTo(o2);
};
System.out.println(comparator.compare(1, 2));
//6.只有一条语句时，return和大括号都可省
Comparator<Integer> comparator = 
    (o1,o2) -> Integer.compare(o1, o2);
System.out.println(comparator.compare(2, 1));
```

### 2 函数式接口

**接口中只声明一个抽象方法**

#### 2.1 格式

```java
@FunctionalInterface	//检验用
public interface MyInterface {
	void Method1();
}
```

#### 2.2 常用内置函数式接口

|     函数式接口      | 参数类型 | 返回类型 |       方法        |
| :-----------------: | :------: | :------: | :---------------: |
|  Consumer<T>消费型  |    T     |   void   | void accept(T t)  |
|  Supplier<T>供给型  |    无    |    T     |      T get()      |
| Function<T,R>函数型 |    T     |    R     |   R apply(T t)    |
| Predicate<T>断定型  |    T     | boolean  | boolean test(T t) |

```java
public void test1() {
    func1(100,a -> System.out.println("money:"+a));
}

public void func1(double money,Consumer<Double> consumer) {
    consumer.accept(money);
}
```

```java
public void test2() {
  List<String> list = Arrays.asList("北京","天津","京京");
  List<String> list2 = filterString(list,s -> s.contains("京"));
  System.out.println(list2);
}

public List<String> filterString
(List<String> list,Predicate<String> pre) {
    ArrayList<String> filterList = new ArrayList<>();
    for (String string : list) {
        if (pre.test(string)) {
            filterList.add(string);
        }
    }
    return filterList;
}
```

#### 2.3 其他接口

![image-20250411211521165](G:\StudySoftware\EclipseWorkspace\clone\javaStudy\text\assets\image-20250411211521165.png)

### 3 方法引用和构造器引用

**使用场景：当传递给Lambda体的操作，已有实现的方法时。**

**方法引用本质上是Lambda表达式，因此也是函数式接口的实例。**

#### 2.1 格式

**类/对象 :: 方法名**

```java
//三种情况
//方法引用要求：接口中抽象方法与方法引用在形参列表、返回值类型上相同（前两种）
对象::实例方法
类::静态方法
类::非静态方法
```

#### 3.2 对象::实例方法

```java
//对象::实例方法
//Consumer中的void accept(T t)
//PrintStream中的void println(T t)
public void test1() {
    PrintStream ps = System.out;
    Consumer<String> con = ps::println;
    con.accept("test1");
}

//Supplier中的T get()
//Employee中的String getName()
public void test2() {
    Employee emp = new Employee(1, "emp", 11, 111);
    Supplier<String> sup = emp::getName;
    System.out.println(sup.get());
}
```

#### 3.3 类::静态方法

```java
//Comparator中的int compare(T t1,T t2)
//Integer中的int compare(T t1,T t2)
public void test3() {
    Comparator<Integer> com = Integer::compare;
    System.out.println(com.compare(1, 2));
}

//Function中的R apply(T t)
//Math中的Long round(Double d)
public void test4() {
    Function<Double, Long> fun = Math::round;
    System.out.println(fun.apply(1.1));//四舍五入
}
```

####  3.4 类::实例方法

**第一个参数作为下面方法的调用者时使用**

```java
//Comparator中的int compare(T t1,T t2)
//String中的int t1.compareTo(t2)
public void test5() {
    Comparator<String> com = String::compareTo;
    System.out.println(com.compare("ab", "ad"));
}
//BiPredicate中的boolean test(T t1,T t2)
//String中的boolean t1.equals(t2)
public void test6() {
    BiPredicate<String, String> pre = String::equals;
    System.out.println(pre.test("ab", "ab"));
}
//Function中的R apply(T t)
//Employee中的String getName()
public void test7() {
    Employee e = new Employee(1, "a", 11, 111);
    Function<Employee, String> fun = Employee::getName;
    System.out.println(fun.apply(e));
}
```

#### 3.5 构造器引用

**与方法引用类似，函数式接口的抽象方法与构造器在形参列表上一致；**

**抽象方法的返回值类型即为构造器所属的类的类型。**

```java
//Supplier中的T get()
//Employee中的空参构造器：Employee()
public void test1() {
    Supplier<Employee> sup1 = () -> new Employee();
    System.out.println(sup1.get());

    Supplier<Employee> sup2 = Employee::new;
    System.out.println(sup2.get());
}

//Function中的R apply(T t)
public void test2() {
    Function<Integer, Employee> fun1 = id -> new Employee(id);
    System.out.println(fun1.apply(11));

    Function<Integer, Employee> fun2 = Employee::new;
    System.out.println(fun2.apply(22));
}

//BiFunction中的R apply(T t,U u)
public void test3() {
    BiFunction<Integer, String, Employee> fun1 = 
        (id,name) -> new Employee(id,name);
    System.out.println(fun1.apply(1, "a"));

    BiFunction<Integer, String, Employee> fun2 = Employee::new;
    System.out.println(fun2.apply(2, "b"));
}
```

#### 3.6 数组引用

与构造器引用类似，可以把数组看作一个特殊的类

```java
//Function中的R apply(T t)
public void test4() {
    System.out.println("test4");
    Function<Integer, String[]> fun1 = length -> new String[length];
    String[] arr1 = fun1.apply(5);
    System.out.println(Arrays.toString(arr1));

    Function<Integer, String[]> fun2 = String[]::new;
    String[] arr2 = fun2.apply(10);
    System.out.println(Arrays.toString(arr2));
}
```



### 4 Stream API

```java
//Stream关注的是对数据的计算，与CPU打交道

//集合关注的是对数据的存储，与内存打交道
```

#### 4.1 特性

```java
//Stream自己不会存储元素

//Stream不会改变源对象，会返回一个持有结果都新Stream

//Stream操作是延迟执行的，会等到需要结果的时候才执行
```

**三步操作：Stream实例化、中间操作（过滤、映射、...）、终止操作**

#### 4.2 Stream实例化

```java
//1通过集合创建Stream
@Test
public void test1() {
  List<Employee> employees = EmployeeData.getEmployees();

    //default Stream<E> stream()：返回一个顺序流
  Stream<Employee> stream = employees.stream();

    //default Stream<E> parallelStream()：返回一个并行流
  Stream<Employee> parallelStream = employees.parallelStream();
}

//2通过数组创建Stream
@Test
public void test2() {
    int[] arr = new int[] {1,2,3,4,5};
    IntStream stream = Arrays.stream(arr);

    Employee e1 = new Employee(1,"a");
    Employee e2 = new Employee(2,"b");
    Employee[] arr1 = new Employee[] {e1,e2};
    Stream<Employee> stream2 = Arrays.stream(arr1);
}

//3通过Stream的of
@Test
public void test3() {
    Stream<Integer> stream = Stream.of(1,2,3,4,5);	
}

//4创建无限流
@Test
public void test4() {
	//迭代
	//public static<T> Stream<T> iterate(final T seed, final 											UnaryOperator<T> f)
    //遍历前10个偶数
    Stream.iterate(0,
               t->t+2).limit(10).forEach(System.out::println);;

    //生成
    //public static<T> Stream<T> generate(Supplier<T> s)
    Stream.generate(Math::random).limit(10).forEach(System.out::println);
}
```

#### 4.3中间操作

**一个中间操作链，对数据源的数据进行处理**。

***1.筛选与切片***

```java
@Test
public void test1() {
    List<Employee> list = new EmployeeData().getEmployees();
    Stream<Employee> stream = list.stream();

//filter(Predicate p) --接收Lambda，从流中排除某些元素		
    System.out.println("filter");
    stream.filter(e -> 		   
                e.getSalary()>50).forEach(System.out::println);
//stream已关闭

//limit(n) --截断流，使其元素不超过给定数量
    System.out.println("limit");
    list.stream().limit(3).forEach(System.out::println);

//skip(n) --跳过元素，返回除去前n个元素的流，若元素不足n个，则返回空流，与limit(n)互补
    System.out.println("skip");
    list.stream().skip(3).forEach(System.out::println);

//distinct() 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
    System.out.println("distinct");

    list.add(new Employee(1010,"a",10,99));
    list.add(new Employee(1010,"a",10,99));
    list.add(new Employee(1010,"a",10,99));
    list.add(new Employee(1010,"a",10,99));
    list.add(new Employee(1011,"a",10,99));

    list.stream().distinct().forEach(System.out::println);;
}
```

***2.映射***

```java
//map(Function f)接收一个函数作为参数，将元素转换成其他形式/提取信息
//该函数会被应用到每个元素上，并将其映射成一个新的元素
public void test1() {
    List<String>list = Arrays.asList("aa","bb","cc","dd");
    list.stream().map(s -> s.toUpperCase()). 		    
        							forEach(System.out::print);
    list.stream().map(String::toUpperCase).
      								forEach(System.out::print);
}

public void test2() {
    List<Employee>employees = EmployeeData.getEmployees();
    Stream<String> nameStream = employees.stream().
        								map(e -> e.getName());
    nameStream.filter(name -> name.length()>1).
        							forEach(System.out::print);
    employees.stream().map(Employee::getId).
        	filter(id -> id>1003).forEach(System.out::print);;
}
```

```java
//flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
public void test3() {
    List<String>list = Arrays.asList("aa","bb","cc","dd");

    Stream<Stream<Character>> streamstream = 
        list.stream().map(Main8StreamAPI3::fromStringToStream);
    streamstream.forEach(s ->{
        s.forEach(System.out::print);
    });
    Stream<Character> flatMap = list.stream().
       			 flatMap(Main8StreamAPI3::fromStringToStream);
    flatMap.forEach(System.out::print);
}

public static Stream<Character> fromStringToStream(String str) {
    ArrayList<Character> arrayList = 
        							new ArrayList<Character>();
    for (Character c : str.toCharArray()) {
        arrayList.add(c);
    }
    return arrayList.stream();
}
```

***3.排序***

```java
//sorted()自然排序
List<Integer> list = Arrays.asList(1,2,3,4,5,0,9,-1);
list.stream().sorted().forEach(System.out::println);
//类使用sorted()要实现Comparable接口

//sorted(Comparator com)定制排序
List<Employee> employees = EmployeeData.getEmployees();
employees.stream().sorted((e1,e2) -> -Integer.compare(e1.getAge(),
   					e2.getAge())).forEach(System.out::println);

employees.stream().sorted((e1,e2) -> {
    int ageValue = -Integer.compare(e1.getAge(), e2.getAge());
    if (ageValue != 0) {
        return ageValue;
    }else {
        return -Double.compare(e1.getSalary(), e2.getSalary());
    }			 
}).forEach(System.out::println);
```



#### 4.4 终止操作	

一旦执行终止操作，就执行中间操作链，并产生结果，之后不会再被使用

***1.匹配与查找***

```java
List<Employee> employees = EmployeeData.getEmployees();
//allMatch(Predicate p)检查是否匹配所有元素
boolean allMatch = employees.stream().
    						   	allMatch(e -> e.getAge() > 5);
System.out.println(allMatch);

//anyMatch(Predicate p)检查是否至少匹配一个元素
boolean anyMatch = employees.stream().
    						anyMatch(e -> e.getId() > 1002);
System.out.println(anyMatch);

//noneMatch(Predicate p)检查是否没有匹配的元素
boolean noneMatch = employees.stream().
    			noneMatch(e -> e.getName().startsWith("a"));
System.out.println(noneMatch);

//findFirst返回第一个元素
Optional<Employee> first = employees.stream().findFirst();
System.out.println(first);

//findAny返回当前流中的任意元素
Optional<Employee> any = employees.parallelStream().findAny();
System.out.println(any);
```

```java
List<Employee> employees = EmployeeData.getEmployees();
//count返回流中元素的总个数
long count = employees.stream().
    					filter(e -> e.getId() > 1005).count();
System.out.println(count);

//max(Comparator c)返回流中最大值
Stream<Double> salaryStream = employees.stream().
    								map(e -> e.getSalary());
Optional<Double> maxSalary = salaryStream.max(Double::compare);
System.out.println(maxSalary);

//min(Comparator c)返回流中最小值
Optional<Employee> employee = employees.stream().
min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
System.out.println(employee);

//forEach(Comsumer c)内部迭代
employees.stream().forEach(System.out::println);
//集合里的默认方法
employees.forEach(System.out::println);
//使用迭代器的是外部迭代
```

***2.归约***

```java
//reduce(T identity,BinaryOperator b)
//可以将流中元素反复结合起来，得到一个值。返回T
//BinaryOperator<T> entends BiFunction<T,T,T> 传入两个返回一个
List<Integer> list = Arrays.asList(1,2,3,4,5);
Integer sum = list.stream().reduce(0,Integer::sum);
System.out.println(sum);
Integer sum2 = list.stream().reduce(10,Integer::sum);
System.out.println(sum2);

//reduce(BinaryOperator b)
//可以将流中元素反复结合起来，得到一个值，返回Opetional<T>
List<Employee> employees = EmployeeData.getEmployees();
Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
Optional<Double> sumMoney = salaryStream.
    								reduce((d1,d2) -> d1+d2);
//Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
System.out.println(sumMoney);
```

***3.收集***

```java
//collect(Collector c)将流转换为其他形式
//接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
List<Employee> employees = EmployeeData.getEmployees();

List<Employee> employeeList = employees.stream().
   				 		filter(e -> e.getSalary() >50).
   								 collect(Collectors.toList());
employeeList.forEach(System.out::println);

Set<Employee> employeeList2 = employees.stream().
  						  filter(e -> e.getSalary() > 50).
  								  collect(Collectors.toSet());
employeeList2.forEach(System.out::println);
```



### 5 Opetional类

 #### 5.1 


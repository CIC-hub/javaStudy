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



### 5 Stream API

#### 5.1

